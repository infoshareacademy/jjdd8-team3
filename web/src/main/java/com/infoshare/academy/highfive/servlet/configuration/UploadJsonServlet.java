package com.infoshare.academy.highfive.servlet.configuration;

import com.infoshare.academy.highfive.exception.JsonFileNotFound;
import com.infoshare.academy.highfive.freemarker.TemplateProvider;
import com.infoshare.academy.highfive.service.configuration.UploadJsonService;
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
import java.io.PrintWriter;
import java.nio.file.Paths;
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
    UploadJsonService uploadJsonService;


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        Map<String, Object> dataModel = new HashMap<>();

        Template template = this.templateProvider.getTemplate(getServletContext(), "template.ftlh");

        dataModel.put("method", req.getMethod());
        dataModel.put("contentTemplate", "upload-json.ftlh");
        dataModel.put("title", "Upload JSON Holidays");
        dataModel.put("pluginJsTemplate", "plugin-js-upload-json.ftlh");

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
        Paths.get(fileName.getSubmittedFileName()).getFileName().toString();
        String realPath = getServletContext().getRealPath("/WEB-INF");

        if (fileName.getSize() == 0) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        List importedList = null;
        try {
            importedList = uploadJsonService.uploadJsonHoliday(fileName, realPath);
        } catch (JsonFileNotFound jsonFileNotFound) {
            jsonFileNotFound.printStackTrace();
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        resp.setStatus(HttpServletResponse.SC_OK);
        writer.println("File <b>" + Paths.get(fileName.getSubmittedFileName()).getFileName().toString() + "</b> uploaded with no errors!");
        writer.println("<br />Total file size: " + (double) (fileName.getSize() / 1000) + "kB");
        writer.println("<br />" + importedList.size() + " holidays added to database!");
        writer.println("<br />" + getServletContext().getRealPath("/"));
    }
}
