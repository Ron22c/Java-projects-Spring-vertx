package com.cranajit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletHello")
public class ServletHello extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("query: "+request.getQueryString());
        PrintWriter out = response.getWriter();
        out.println("<h1> First: " + request.getParameter("first") + "</h1>");
        out.println("<h1> second: " + request.getParameter("second") + "</h1>");
    }
}
