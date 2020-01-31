package com.infoshare.academy.highfive.web.servlet;

import com.infoshare.academy.highfive.domain.Employee;
import com.infoshare.academy.highfive.domain.Role;
import com.infoshare.academy.highfive.dto.request.EmployeeRequest;
import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.service.EmployeeService;
import com.infoshare.academy.highfive.web.servlet.filters.AuthenticationService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.hibernate.usertype.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.infoshare.academy.highfive.web.servlet.filters.AuthenticationService;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("")
public class LoginServlet extends HttpServlet {

    Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private AuthenticationService authenticationService;

    @Inject
    private EmployeeService employeeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        Template template = templateProvider
                .getTemplate(getServletContext(), "login.ftlh");

        Map<String, Object> model = new HashMap<>();

        String role = (String) req.getAttribute("role");
        String user = (String) req.getAttribute("authorization");

        model.put("role", role);
        model.put("authorization", user);

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
          LOGGER.warn("Issue with processing Freemarker template.{}", e.getMessage());
        }
        String code = req.getParameter("code");
        String state = req.getParameter("state");

//        if ((code != null) && !code.isEmpty() && (state != null) && !state.isEmpty()) {
//
//            if (req.getSession().getAttribute("googleId") == null) {
//                String googleJson = AuthenticationService.getUserInfoJson(code);
//                JsonObject googleUser = Json.createReader(new StringReader(googleJson)).readObject();
//
//                String googleUserEmail = googleUser.getString("email");
//                String googleUserId = googleUser.getString("id");
//
//
//
//                if (EmployeeService.employee(googleUserEmail)) {
//
//                    Optional<EmployeeRequest> employeeDto = Employee.getUserByEmail(googleUserEmail);
//
//
//                    req.getSession().setAttribute("userType", employeeDto.get().getUserType());
//                    req.getSession().setAttribute("googleId", employeeDto.get().getGoogleId());
//                    req.getSession().setAttribute("googleEmail", employeeDto.get().getEmail());
//
//
//                } else {
//
//                    EmployeeRequest userDto = new EmployeeRequest();
//                    userDto.setGoogleId(googleUserId);
//                    userDto.setEmail(googleUserEmail);
//                    userDto.setRole(Role.ADMIN);
//
//                    employeeService.addNewEmployee(userDto);
//
//                    req.getSession().setAttribute("", userDto.getUserType());
//                    req.getSession().setAttribute("googleId", userDto.getGoogleId());
//                    req.getSession().setAttribute("googleEmail", userDto.getEmail());
//
//
//                }
//            }
//        }
//        final String googleId = (String) req.getSession().getAttribute("googleId");
//
//        if (googleId != null && !googleId.isEmpty()) {
//            model.put("logged", "yes");
//        } else {
//            model.put("logged", "no");
//            model.put("loginUrl", AuthenticationService.buildLoginUrl());
//        }
//
           }
    }

