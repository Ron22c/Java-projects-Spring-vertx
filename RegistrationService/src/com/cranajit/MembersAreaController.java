package com.cranajit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MembersAreaController", urlPatterns = {"/membersareacontroller"})
public class MembersAreaController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action != null) {
            switch (action) {
                case "destroy":
                    request.getSession().invalidate();
                    response.sendRedirect("login.jsp");
                    /**
                     * Replacing cookie with session attribure
                     * Cookie[] cookies = request.getCookies();
                     * if(cookies!=null) {
                     *   for(Cookie c: cookies) {
                     *      if(c.getName().equals("userId")){
                     *          c.setValue(null);
                     *          c.setMaxAge(0);
                     *          response.addCookie(c);
                     *
                     *          }
                     *      }
                     *  }
                     */

                    break;
                default:
                    break;
            }
        }
    }
}
