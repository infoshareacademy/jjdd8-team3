package com.infoshare.academy.highfive.servlet.configuration;

import com.infoshare.academy.highfive.cdi.FileUploadProcessor;
import com.infoshare.academy.highfive.domain.Holiday;
import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.parser.ApiJsonParser;
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
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MultipartConfig
@WebServlet("/admin/upload-json")
public class UploadJsonServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());


    @Inject
    private TemplateProvider templateProvider;

    @Inject
    FileUploadProcessor fileUploadProcessor;

    @Inject
    HolidayService holidayService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();

        Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

        dataModel.put("method", req.getMethod());
        dataModel.put("contentTemplate", "upload-json.ftlh");
        dataModel.put("title", "Upload JSON Holidays");
//        dataModel.put("pluginCssTemplate", "plugin-css-all-holiday.ftlh");
        dataModel.put("pluginJsTemplate", "plugin-js-upload-json.ftlh");
        // dataModel.put("holidays", holidayService.listAllHoliday());


        try {
            template.process(dataModel, writer);
        } catch (
                TemplateException e) {
            e.getMessage();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part fileName = req.getPart("file-name");

        if (fileName == null || fileName.getSize() == 0) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        InputStream uploadedFile = null;
        InputStream fileContent = fileName.getInputStream();
//        try {
//            uploadedFile = fileUploadProcessor.uploadJsonFile(fileName);
//        } catch (JsonFileNotFound userImageNotFound) {
//            logger.warn(userImageNotFound.getMessage());
//        }
        ApiJsonParser apiJsonParser = new ApiJsonParser();
        List<Holiday> holidayList = apiJsonParser.parseFromFile(fileContent);
        holidayList.forEach(holiday -> holidayService.saveHoliday(holiday));

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
