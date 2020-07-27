package com.cranajit;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {

    @Resource(name = "JDBC/project")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            String query = "SELECT * from users;";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                System.out.println(resultSet.getString("email"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String action = request.getParameter("action");
        if(action!= null) {
            switch (action) {
                case "signup" :
                    registrationProcessor(request, response);
                case "login" :
                    loginProcessor(request, response);
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/controller?page=login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page!=null) {
            switch (page) {
                case "signup":
                    request.getRequestDispatcher("views/signup.jsp").forward(request, response);
                    break;
                case "login":
                    request.getRequestDispatcher("views/login.jsp").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            response.getWriter().println("<h1>PLEASE PROVIDE A SPECIFIC PATH</h1>");
        }
    }

    public void registrationProcessor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        String name = request.getParameter("first")+ " " +request.getParameter("last");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String[] languages = request.getParameterValues("language");
        writer.println("REGISTRATION SUCCESSFUL FOR USER: "+name);
    }

    public void loginProcessor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        if(userName.equals("ron") && password.equals("qwerty")) {
            request.getSession().invalidate();
            HttpSession session = request.getSession(true);
            session.setAttribute("username", userName);
            Cookie cookie = new Cookie("name", userName);
            response.addCookie(cookie);
            response.sendRedirect(request.getContextPath()+"/membercontroller?action=member");
        } else {
            response.sendRedirect(request.getContextPath()+"/controller?page=login");
        }
    }
}
