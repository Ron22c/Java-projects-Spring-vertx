package com.cranajit.controllers;

import com.cranajit.DAO.UserModelDAO;
import com.cranajit.config.AppConfig;
import com.cranajit.models.UserModel;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("index");
        UserModel model = new UserModel();

        Map<String, String> gender = new HashMap<>();
        gender.put("MALE", "male");
        gender.put("FEMALE", "female");

        Map<String, String> language = new HashMap<>();
        language.put("BENGALI", "bengali");
        language.put("ENGLISH", "english");
        language.put("SPANISH", "spanish");

        String[] country = {"india", "USA", "UK"};

        mv.addObject("user", model);
        mv.addObject("gender", gender);
        mv.addObject("language", language);
        mv.addObject("country", country);

        return mv;
    }

    @PostMapping("/register")
    public ModelAndView registration(@ModelAttribute UserModel model) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserModelDAO userModelDAO = context.getBean("daoClass", UserModelDAO.class);
        userModelDAO.addUser(model);
        ModelAndView mv = new ModelAndView("successful");
        List<UserModel> usersList = userModelDAO.getAllUser();
        mv.addObject("users", usersList);
        return mv;
    }

    @GetMapping("/register")
    public ModelAndView showUsers() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserModelDAO userModelDAO = context.getBean("daoClass", UserModelDAO.class);
        ModelAndView mv = new ModelAndView("successful");
        List<UserModel> usersList = userModelDAO.getAllUser();
        mv.addObject("users", usersList);
        return mv;
    }

    @RequestMapping("/login")
    public String login(Model model, UserModel user) {
        System.out.println(user);
        model.addAttribute("user", user);
        return "login";
    }
}
