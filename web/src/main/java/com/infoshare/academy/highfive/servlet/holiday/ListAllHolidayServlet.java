package com.infoshare.academy.highfive.servlet.holiday;

import com.infoshare.academy.highfive.service.HolidayService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet
public class ListAllHolidayServlet extends HttpServlet {

   // @Inject
   // private TemplateProvider templateProvider;

    @Inject
    HolidayService holidayService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body><h1>Table</h1></body>");

        writer.println("</html>");
    }
}
