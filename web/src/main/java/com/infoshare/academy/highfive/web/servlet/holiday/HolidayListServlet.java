package com.infoshare.academy.highfive.web.servlet.holiday;

import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.service.HolidayService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/list-holidays")
public class HolidayListServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    HolidayService holidayService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();

        Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

        dataModel.put("method", req.getMethod());
        dataModel.put("contentTemplate", "all-holiday.ftlh");
        dataModel.put("title", "List Holidays");
        dataModel.put("pluginCssTemplate", "plugin-css-all-holiday.ftlh");
        dataModel.put("pluginJsTemplate", "plugin-js-all-holiday.ftlh");
        dataModel.put("holidays", holidayService.findAll());

        try {
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            e.getMessage();
        }

    }

}
