package com.infoshare.academy.highfive.servlet.holiday;

import com.infoshare.academy.highfive.domain.HolidayType;
import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.service.holiday.HolidayService;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@MultipartConfig
@WebServlet("/admin/add-holiday")
public class AddHolidayServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());


    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private HolidayService holidayService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String action = req.getParameter("action");
        PrintWriter writer = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();

        Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");



        dataModel.put("method", req.getMethod());
        dataModel.put("contentTemplate", "add-holiday.ftlh");
        dataModel.put("title", "Add holiday");
        dataModel.put("action", "add");
        dataModel.put("holidayTypes", HolidayType.values());
        dataModel.put("pluginJsTemplate", "plugin-js-add-holiday.ftlh");

        try {
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            e.getMessage();
        }

    }

}
