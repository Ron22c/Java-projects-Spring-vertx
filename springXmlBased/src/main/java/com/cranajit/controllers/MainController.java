package com.cranajit.controllers;

import com.cranajit.DAO.UserModelDao;
import com.cranajit.models.UserModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView signup() {
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

    @PostMapping("/setUserData")
    public String saveUserData(@ModelAttribute UserModel model){
        System.out.println(model);
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("database.xml");
        UserModelDao userModelDao = context.getBean("daoClass", UserModelDao.class);
        userModelDao.registerUser(model);
        return "success";
    }

    @RequestMapping("/login")
    public String login(Model model, @Valid UserModel user, BindingResult result) {
        if(!result.hasErrors()){
            System.out.println(user);
            model.addAttribute("user", user);
            return "login";
        } else {
            if(user.getPhone()==null) {
                System.out.println("inside else");
                model.addAttribute("user", user);
                return "login";
            } else {
                return "forward:/";
            }
        }
    }

    @ExceptionHandler(Exception.class)
    public String exceptionHandle(Exception e) {
        return "error";
    }
}
