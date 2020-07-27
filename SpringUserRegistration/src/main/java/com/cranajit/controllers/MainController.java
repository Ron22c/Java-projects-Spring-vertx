package com.cranajit.controllers;

import com.cranajit.daoclasses.UserDAO;
import com.cranajit.daoclasses.UserDaoDS;
import com.cranajit.models.UserModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView home() {
        Map<String,String> gender = new HashMap<>();
        gender.put("male", "MALE");
        gender.put("female", "FEMALE");

        UserModel user = new UserModel();

        ModelAndView model = new ModelAndView("index");
        model.addObject("gender", gender);
        model.addObject("user", user);
        return model;
    }

    @PostMapping("/user")
    public String user(@ModelAttribute UserModel model) {
        if(model != null) {
            ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("context.xml");
            UserDaoDS dao = context.getBean("DAObean", UserDaoDS.class );
            dao.setGender(model);
            return "success";
        }
        return "index";
    }
}
