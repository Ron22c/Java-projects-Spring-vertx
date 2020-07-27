package com.cranajit.contollers;

import com.cranajit.models.UserInfoModel;
import com.cranajit.processors.DatabaseProcessor;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "Controller", urlPatterns={"/controller"})
public class Controller extends HttpServlet {
    @Resource(name = "JDBC/project")
    DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "signup":
                registrationProcessor(request, response);
                break;
            case "login":
                loginProcessor(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath()+"controller?page=login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page!=null) {
            switch (page) {
                case "login":
                    request.getRequestDispatcher("views/login.jsp").forward(request, response);
                    break;
                case "signup":
                    request.getRequestDispatcher("views/signup.jsp").forward(request, response);
                    break;
                default:
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                    break;
            }
        } else {
            response.getWriter().println("PAGE NOT FOUND");
        }
    }

    protected void loginProcessor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        if(password !=null && phone!=null) {
            String pass = DatabaseProcessor.loginUserInfo(phone, dataSource);
            if(pass.equals(password)) {
                request.getSession().invalidate();
                HttpSession session = request.getSession(true);
                session.setAttribute("phone", phone);
                Cookie c = new Cookie("user", phone);
                response.addCookie(c);
                response.sendRedirect(request.getContextPath()+"/members?action=member");
            } else {
                response.sendRedirect(request.getContextPath()+"/controller?page=login");
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/controller?page=login");
        }
    }

    protected void registrationProcessor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("first");
        String lastName = request.getParameter("last");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String languages = "";
        String[] language = request.getParameterValues("language");

        if(language!=null) {
            for(String l: language) {
                languages = languages.concat(l+" ,");
            }
        }

        UserInfoModel model = new UserInfoModel(phone, firstName, lastName, password, gender, languages, country);
        int isSavedIntoDB = DatabaseProcessor.insertUserInfo(model, dataSource);
        if(isSavedIntoDB==1) response.getWriter().print("REGISTRATION SUCCESSFUL!! PLEASE LOGIN TO THE CONSOLE WITH THE PHONE & PASSWORD");
        else response.getWriter().print("REGISTRATION FAILED!! PLEASE RETRY");
    }
}
