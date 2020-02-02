package com.infoshare.academy.highfive.web.servlet.holiday;

import com.infoshare.academy.highfive.domain.HolidayType;
import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.service.HolidayService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@MultipartConfig
@WebServlet("/admin/add-holiday")
public class AddHolidayServlet extends HttpServlet {

    private Logger LOGGER = LoggerFactory.getLogger(getClass().getName());


    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private HolidayService holidayService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");
        String id = req.getParameter("get");

        if (action == null || action.isEmpty()) {
            action = "add";
        }

        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        Map<String, Object> dataModel = new HashMap<>();

        Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

        dataModel.put("method", req.getMethod());
        dataModel.put("contentTemplate", "add-holiday.ftlh");

        if (action.equals("edit")) {
            dataModel.put("action", "edit");
            dataModel.put("holiday", holidayService.finById(Long.parseLong(id)));
        } else {
            dataModel.put("title", "Add holiday");
            dataModel.put("action", "add");
        }
        dataModel.put("holidayTypes", HolidayType.values());
        dataModel.put("pluginCssTemplate", "plugin-css-stylesheet.ftlh");
        dataModel.put("pluginJsTemplate", "plugin-js-add-holiday.ftlh");

        dataModel.put("loggedEmployee", session.getAttribute("loggedEmployee") );
        dataModel.put("loggedEmployeeRole",session.getAttribute("loggedEmployeeRole") );

        try {
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            LOGGER.warn("Issue with processing Freemarker template.{}", e.getMessage());
        }

    }

}
