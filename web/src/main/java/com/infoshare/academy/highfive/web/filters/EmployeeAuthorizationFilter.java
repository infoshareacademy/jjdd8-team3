package com.infoshare.academy.highfive.web.filters;

import com.infoshare.academy.highfive.domain.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "EmployeeAuthorizationFilter",
  urlPatterns = {"*/employee/*"}
  ,
  initParams = {
    @WebInitParam(name = "loggedEmployeeRole", value = "employee")
  }
)
public class EmployeeAuthorizationFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest mainRequest, ServletResponse mainResponse, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) mainRequest;
    HttpServletResponse response = (HttpServletResponse) mainResponse;
    HttpSession session = request.getSession();

    Role role = Role.valueOf(session.getAttribute("loggedEmployeeRole").toString());

    if (role == Role.EMPLOYEE || role == Role.MANAGER || role == Role.ADMIN) {
      chain.doFilter(mainRequest, mainResponse);
    } else {
      response.sendRedirect("/");
      destroy();
    }

  }

  @Override
  public void destroy() {


  }
}
