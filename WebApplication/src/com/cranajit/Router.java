package com.cranajit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Router")
public class Router extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        System.out.println(page);
        if(page.equals("login")) {
            request.getRequestDispatcher("/loginPage.jsp").forward(request, response);
        } else if(page.equals("signup")) {
            request.getRequestDispatcher("/signUpPage.jsp").forward(request, response);
        } else if(page.equals("about")) {
            request.getRequestDispatcher("/aboutPage.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/notFound.jsp").forward(request, response);
        }
    }
}
