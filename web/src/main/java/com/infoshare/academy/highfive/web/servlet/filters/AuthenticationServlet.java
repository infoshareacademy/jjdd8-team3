package com.infoshare.academy.highfive.web.servlet.filters;

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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;


@WebServlet("")
public class AuthenticationServlet extends HttpServlet {
    public static final String FILENAME = "Json_example.json";
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private EventDTO_mock eventDTO_mock = new EventDTO_mock();

    @Inject
    private EmployeeService employeeService;

    @Inject
    private TemplateProvider templateProvider;
    private AuthenticationService authenticationService = new AuthenticationService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        eventDTO_mock.setDescShort("Gimnastyka prozdrowotna dla kobiet 50 +Zaj\u0119cia prozdrowotne i uelastyczniaj\u0105ce dla kobiet 50+.Grupa wiekowa: Kobiety 50+Cena: 20 z\u0142 \u2013 pojedyncze zaj\u0119cia,70 z\u0142 - miesi\u0105c (1x w tygodniu)120 z\u0142 - miesi\u0105c (2x w tygodniu)Cz\u0119stotliwo\u015b\u0107 zaj\u0119\u0107...");
        eventDTO_mock.setName("Gimnastyka prozdrowotna");
        eventDTO_mock.setUrls("http://wyspaskarbow.gak.gda.pl");

        Template template = templateProvider.getTemplate(getServletContext(), "welcome-page.ftlh");
        Map<String, Object> model = new HashMap<>();

        model.put("eventDTO_mock", eventDTO_mock);

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("Content-Type = text/html");

        String code = req.getParameter("code");
        logger.info("Code initial {}", code);
        String state = req.getParameter("state");
        logger.info("State initial {}", state);

        if ((code != null) && !code.isEmpty() && (state != null) && !state.isEmpty()) {

            if (req.getSession().getAttribute("googleId") == null) {
                String googleJson = authenticationService.getUserInfoJson(code);
                JsonObject googleUser = Json.createReader(new StringReader(googleJson)).readObject();

                String googleUserEmail = googleUser.getString("email");
                String googleUserId = googleUser.getString("id");

                logger.info("Google user logged {}", googleUserEmail);

                logger.info("Is user in DB: {}", googleUserEmail);

                if (employeeService.employeeExist(googleUserEmail)) {

                    Optional<UserDto> userDto = employeeService.getUserByEmail(googleUserEmail);
                    logger.info("UserType from DB {}", userDto.get().getUserType());

                    req.getSession().setAttribute("userType", userDto.get().getUserType());
                    req.getSession().setAttribute("googleId", userDto.get().getGoogleId());
                    req.getSession().setAttribute("googleEmail", userDto.get().getEmail());

                    logger.info("Usertype from db {}", req.getSession().getAttribute("userType"));
                    logger.info("Googleid from db {}", req.getSession().getAttribute("googleId"));
                    logger.info("GoogleEmail from db {}", req.getSession().getAttribute("googleEmail"));

                } else {

                    UserDto userDto = new UserDto();
                    userDto.setGoogleId(googleUserId);
                    userDto.setEmail(googleUserEmail);
                    userDto.setUserType(UserType.USER);

                    employeeService.createNewUser(userDto);

                    req.getSession().setAttribute("userType", userDto.getUserType());
                    req.getSession().setAttribute("googleId", userDto.getGoogleId());
                    req.getSession().setAttribute("googleEmail", userDto.getEmail());

                    logger.info("Usertype sent to DB {}", userDto.getUserType());
                    logger.info("Googleid sent to DB {}", userDto.getGoogleId());
                    logger.info("GoogleEmail sent to DB {}", userDto.getEmail());
                }
            }
        }
        final String googleId = (String) req.getSession().getAttribute("googleId");
        logger.info("GoogleId: {}", googleId);

        if (googleId != null && !googleId.isEmpty()) {
            model.put("logged", "yes");
        } else {
            model.put("logged", "no");
            model.put("loginUrl", authenticationService.buildLoginUrl());
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}
