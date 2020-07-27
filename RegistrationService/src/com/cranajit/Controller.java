package com.cranajit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Name: "+request.getParameter("first")+request.getParameter("last"));
        out.println("Gender: "+request.getParameter("gender"));
        out.println("Country: "+request.getParameter("country"));
        String[] language = request.getParameterValues("language");
        if(language != null) {
            out.println("languages Known");
            for(int i=0; i<language.length; i++) {
                out.println(language[i]);
            }
        }
        out.print("REGISTRATION SUCCESSFUL");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page != null){
            if(page.equals("signup")) {
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            } else if(page.equals("login")){
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else{
            response.getWriter().println("PLEASE PROVIDE A QUERY PARAM: page=your page name");
        }
    }
}
