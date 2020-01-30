package com.infoshare.academy.highfive.web.servlet.filters;

import com.infoshare.academy.highfive.dto.request.EmployeeRequest;
import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.service.EmployeeService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.hibernate.usertype.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.management.relation.Role;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@WebServlet("")
public class AuthenticationServlet extends HttpServlet {
    public static final String FILENAME = "Json_example.json";

    @Inject
    private EmployeeService employeeService;

    @Inject
    private TemplateProvider templateProvider;
    private AuthenticationService authenticationService = new AuthenticationService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {


        Template template = templateProvider.getTemplate(getServletContext(), "login.ftlh");
        Map<String, Object> model = new HashMap<>();

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("Content-Type = text/html");

        String code = req.getParameter("code");

        String state = req.getParameter("state");


        if ((code != null) && !code.isEmpty() && (state != null) && !state.isEmpty()) {

            if (req.getSession().getAttribute("googleId") == null) {
                String googleJson = authenticationService.getUserInfoJson(code);
                JsonObject googleUser = Json.createReader(new StringReader(googleJson)).readObject();
                String googleUserEmail = googleUser.getString("email");
                String googleUserId = googleUser.getString("id");

                if (employeeService.employeeExist(googleUserEmail)) {

                    Optional<EmployeeRequest> employeeDTO = employeeService.getEmployeeByEmail(googleUserEmail);
                    req.getSession().setAttribute("role", employeeDTO.get().getRole());
                    req.getSession().setAttribute("googleId", employeeDTO.get().getGoogleId());
                    req.getSession().setAttribute("googleEmail", employeeDTO.get().getEmail());

                } else {

                    EmployeeRequest employeeDTO = new EmployeeRequest();
                    employeeDTO.setGoogleId(googleUserId);
                    employeeDTO.setEmail(googleUserEmail);
//                    employeeDTO.setRole(R);

                    employeeService.addNewEmployee(employeeDTO);

                    req.getSession().setAttribute("userType", employeeDTO.getRole());
                    req.getSession().setAttribute("googleId", employeeDTO.getGoogleId());
                    req.getSession().setAttribute("googleEmail", employeeDTO.getEmail());

                }
            }
        }
        final String googleId = (String) req.getSession().getAttribute("googleId");


        if (googleId != null && !googleId.isEmpty()) {
            model.put("logged", "yes");
        } else {
            model.put("logged", "no");
            model.put("loginUrl", authenticationService.buildLoginUrl());
        }


    }
}
