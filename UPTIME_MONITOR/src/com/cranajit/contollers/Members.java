package com.cranajit.contollers;

import com.cranajit.entityclasses.UserFileUpload;
import com.cranajit.hibernateDAO.UserFileUploadDAO;
import com.cranajit.models.UserInfoModel;
import com.cranajit.processors.DatabaseProcessor;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Members", urlPatterns = {"/members"})
public class Members extends HttpServlet {
    @Resource(name = "JDBC/project")
    DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action!=null) {
            switch (action) {
                case "member":
                    List<UserInfoModel> userData = DatabaseProcessor.getAllMembersInfo(dataSource);
                    request.setAttribute("userData", userData);
                    request.getRequestDispatcher("views/members.jsp").forward(request, response);
                    break;
                case "logout":
                    request.getSession().invalidate();
                    Cookie[] cookies = request.getCookies();
                    for(Cookie cookie : cookies) {
                        if(cookie.getName().equals("user")) {
                            cookie.setValue(null);
                            cookie.setMaxAge(0);
                        }
                    }
                    response.sendRedirect(request.getContextPath()+"/controller?page=login");
                    break;
                case "update":
                    UserInfoModel user = DatabaseProcessor.getUserInfo(request.getParameter("phone"), dataSource);
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("views/updateuser.jsp").forward(request, response);
                    break;
                case "delete":
                    String phone = request.getParameter("phone");
                    int deletedUser = DatabaseProcessor.deleteUser(dataSource, phone);
                    if(deletedUser==1) {
                        response.sendRedirect(request.getContextPath()+"/members?action=logout");
                    } else {
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                    break;
            }
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action!=null) {
            switch(action) {
                case "updateUserInfo":
                    updateUserInfo(request, response);
                    break;
                case "imageupload":
                    uploadImage(request, response);
                    break;
            }
        } else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void uploadImage(HttpServletRequest request, HttpServletResponse response) {
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        try {
            List<FileItem> files = upload.parseRequest(request);
            for(FileItem file: files) {
                File fileTOUpload = new File("/Users/cranajit/Desktop/LOCKDOWN/JAVA/UPTIME_MONITOR/web/uploadedfiles/"+file.getName());
                if(!fileTOUpload.exists()) {
                    String phone = request.getParameter("phone");
                    new UserFileUploadDAO().insertUploadedFileDetails(new UserFileUpload(phone, file.getName(), "Demo"));
                    file.write(fileTOUpload);
                }
            }
            response.sendRedirect(request.getContextPath()+"/members?action=member");
        } catch (FileUploadException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("first");
        String lastName = request.getParameter("last");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String languages = "";
        String[] language = request.getParameterValues("language");
        String phone = request.getParameter("phone");

        if(language!=null) {
            for(String l: language) {
                languages = languages.concat(l+" ,");
            }
        }
        UserInfoModel model = new UserInfoModel(firstName, lastName, password, gender, languages, country);
        int rowsUpdated = DatabaseProcessor.updateUserInfo(dataSource, model, phone);
        if(rowsUpdated ==1) {
            System.out.println("USER UPDATED");
            response.sendRedirect(request.getContextPath()+"/members?action=member");
        }
        else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
