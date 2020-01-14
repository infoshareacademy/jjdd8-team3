package com.infoshare.academy.highfive.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@WebServlet ("/manager/add-user/")
public class AddUserServlet extends HttpServlet {

private static final Logger logger = Logger.getLogger(AddUserServlet.class.getName());

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse resp){


}
}
