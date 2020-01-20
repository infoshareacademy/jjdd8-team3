package com.infoshare.academy.highfive.servlet.holiday;

import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.service.holiday.HolidayService;
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

@WebServlet("/search-by-date")
public class SearchByDateServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    HolidayService holidayService;

//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html;charset=UTF-8");
//
//        PrintWriter writer = resp.getWriter();
//
//        Map<String, Object> dataModel = new HashMap<>();
//
//        Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");
//
//        dataModel.put("method", req.getMethod());
//        dataModel.put("contentTemplate", "holiday-search-by-date.ftlh");
//        dataModel.put("title", "Search result by date");
//        dataModel.put("pluginCssTemplate", "plugin-css-all-holiday.ftlh");
//        dataModel.put("pluginJsTemplate", "plugin-js-all-holiday.ftlh");
//        dataModel.put("holidays", holidayService.searchHolidayByDate());
//
//
//        try {
//            template.process(dataModel, writer);
//        } catch (
//                TemplateException e) {
//            e.getMessage();
//        }
//
//    }
//
//TODO
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        try {
//            VacationRequest vacationRequest = vacationRequestMapper.mapParamsToRequest(req);
//            this.vacationService.addVacation(vacationRequest);
//
//        } catch (ParseException e) {
//            LOGGER.warn("Issue with parsing http request.");
//            e.printStackTrace();
//        }
//
//        Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");
//
//        resp.setContentType("text/html;charset=UTF-8");
//        PrintWriter writer = resp.getWriter();
//        Map<String, Object> dataModel = new HashMap<>();
//
//        LOGGER.debug("Status {}", vacationService.getStatus());
//
//        if (vacationService.getStatus().equals("ok")) {
//
//            dataModel.put("contentTemplate", "request-vacation-success.ftlh");
//            dataModel.put("title", "Success!");
//
//        } else if (vacationService.getStatus().equals("exceeding_entitlement")) {
//
//            dataModel.put("contentTemplate", "request-vacation-exceeding-entitlement.ftlh");
//            dataModel.put("title", "Given days are exceeding entitlement.");
//
//        } else {
//
//            dataModel.put("contentTemplate", "request-vacation-wrong-date.ftlh");
//            dataModel.put("title", "Wrong dates given.");
//
//        }
//
//        try {
//            template.process(dataModel, writer);
//        } catch (
//                TemplateException e) {
//            LOGGER.warn("Issue with processing Freemarker template.");
//            e.getMessage();
//        }
//
//    }
}
