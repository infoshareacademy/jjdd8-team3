package com.infoshare.academy.highfive.servlet;


import com.infoshare.academy.highfive.service.holiday.HolidayService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class MZSearchHolidayByNameServlet extends HttpServlet {

    @Inject
    HolidayService holidayService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String queryByName = req.getQueryString();
//        holidayService.searchHolidayByName(queryByName);

//        String inputSearch = req.getParameter("inputSearch");

//        String reqUser = "*" + inputSearch + "*";

//        @Query(reqUser="select * from holiday h where h.name like %:inputSearch%", nativeQuery=true)
    }
}
