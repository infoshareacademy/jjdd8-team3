package com.infoshare.academy.highfive.web.servlet.holiday;

import com.infoshare.academy.highfive.dto.view.HolidayView;
import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.service.HolidayService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/search-by-date")
public class SearchHolidayByDateServlet extends HttpServlet {

    Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    private String DATE_PATTERN = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";

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
        dataModel.put("contentTemplate", "holiday-search.ftlh");
        dataModel.put("title", "Search result by date");
        dataModel.put("pluginCssTemplate", "plugin-css-all-holiday.ftlh");
        dataModel.put("pluginJsTemplate", "plugin-js-all-holiday.ftlh");

        try {
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            e.getMessage();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dateFrom = req.getParameter("date-from");
        String dateTo = req.getParameter("date-to");

        List<HolidayView> holidays = null;
        Boolean validInputs = false;

        LOGGER.info("Checking date format from inputs!");

        if (dateFrom.matches(DATE_PATTERN) && dateTo.matches(DATE_PATTERN)) {
            validInputs = true;
            LOGGER.info("Inputs Correct. Processing!");
            LocalDate dateFromD = LocalDate.parse(dateFrom);
            LocalDate dateToD = LocalDate.parse(dateTo);
            holidays = holidayService.searchHolidayByDate(dateFromD, dateToD);

        }


        Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("method", req.getMethod());
        dataModel.put("contentTemplate", "holiday-search-result.ftlh");
        dataModel.put("title", "Search result by date");
        dataModel.put("pluginCssTemplate", "plugin-css-all-holiday.ftlh");
        dataModel.put("pluginJsTemplate", "plugin-js-all-holiday.ftlh");
        dataModel.put("validInputs", validInputs);
        dataModel.put("searchType", "by date");
        dataModel.put("holidays", holidays);

        try {
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            LOGGER.warn("Issue with processing Freemarker template.");
            e.getMessage();
        }

    }
}
