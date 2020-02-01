package com.infoshare.academy.highfive.web.filters;

import com.infoshare.academy.highfive.domain.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "ManagerAuthorizationFilter",
        urlPatterns = {"*/manager/*"})
public class ManagerAuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest mainRequest, ServletResponse mainResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) mainRequest;
        HttpSession session = request.getSession();

        Role role = Role.valueOf(session.getAttribute("loggedEmployeeRole").toString());

        if (role == Role.MANAGER || role == Role.ADMIN){
            chain.doFilter(mainRequest, mainResponse);
        } else {
            destroy();
        }

    }

    @Override
    public void destroy() {

    }
}
