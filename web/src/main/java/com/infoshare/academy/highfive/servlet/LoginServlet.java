package com.infoshare.academy.highfive.servlet;

import com.infoshare.academy.highfive.freemarker.TemplateProvider;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

  Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Inject
  private TemplateProvider templateProvider;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
      logger.warn(e.getMessage());
      logger.debug("aaaa");
    }
  }
}
