package com.cranajit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MemberController", urlPatterns = {"/membercontroller"})
public class MemberController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action!=null) {
            switch (action){
                case "memberlogout":
                    request.getSession().invalidate();
                    Cookie[] cookies = request.getCookies();
                    if(cookies!=null) {
                        for(Cookie c:cookies) {
                            if(c.getName().equals("name")){
                                c.setValue(null);
                                c.setMaxAge(0);
                            }
                        }
                    }
                    response.sendRedirect(request.getContextPath()+"/controller?page=login");
                    break;
                case "member":
                    request.getRequestDispatcher("views/members.jsp").forward(request, response);
                case "memberfriend":
                    request.getRequestDispatcher("views/memberFriend.jsp").forward(request, response);
            }
        } else {
            response.getWriter().println("PLEASE PROVIDE A VALID PATH");
        }
    }
}
