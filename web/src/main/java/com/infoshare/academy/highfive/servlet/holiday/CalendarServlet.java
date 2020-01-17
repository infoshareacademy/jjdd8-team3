package com.infoshare.academy.highfive.servlet.holiday;

import com.infoshare.academy.highfive.service.holiday.HolidayService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalendarServlet extends HttpServlet {

    @Inject
    HolidayService holidayService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
