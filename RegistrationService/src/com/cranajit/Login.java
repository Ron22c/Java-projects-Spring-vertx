package com.cranajit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userid");
        String password = request.getParameter("password");
        if(userId.equals("ron") && password.equals("qwerty")) {
            request.getSession().invalidate();
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(300);
            /**
             * Replacing cookie with session attributes
             * Cookie cUserId = new Cookie("userId", userId);
             * response.addCookie(cUserId);
             */
            session.setAttribute("userId", userId);
            response.sendRedirect("Home.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
