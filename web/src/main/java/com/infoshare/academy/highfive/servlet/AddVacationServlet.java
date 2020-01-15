package com.infoshare.academy.highfive.servlet;

import com.infoshare.academy.highfive.mapper.request.VacationRequestMapper;
import com.infoshare.academy.highfive.request.VacationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet("employee/add-vacation")
public class AddVacationServlet extends HttpServlet {

  Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Inject
  private VacationRequestMapper vacationRequestMapper;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    try {
      VacationRequest vacationRequest = vacationRequestMapper.mapParamsToRequest(req);
    } catch (ParseException e) {
      e.printStackTrace();
    }

  }
}
