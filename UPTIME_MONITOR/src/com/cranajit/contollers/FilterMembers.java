package com.cranajit.contollers;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FilterMembers", urlPatterns = {"/members"})
public class FilterMembers implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if(request.getSession().getAttribute("phone") != null) {
            chain.doFilter(req, resp);
        } else {
            response.sendRedirect(request.getContextPath()+"/controller?page=login");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
