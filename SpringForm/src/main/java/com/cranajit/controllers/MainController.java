package com.cranajit.controllers;

import com.cranajit.models.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {
    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        UserModel model = new UserModel();

        Map<String, String> gender = new HashMap<>();
        gender.put("male", "MALE");
        gender.put("female", "FEMALE");

        Map<String, String> country = new HashMap<>();
        country.put("india", "INDIA");
        country.put("usa", "USA");
        country.put("canada", "CANADA");
        country.put("nepal", "NEPAL");

        modelAndView.addObject("country", country);
        modelAndView.addObject("gender", gender);
        modelAndView.addObject("user", model);
        return modelAndView;
    }

    @PostMapping("/showuserdata")
    public ModelAndView showUserData(@ModelAttribute @Valid UserModel model, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("userdata");
        modelAndView.addObject("model", model);
        if(result.hasErrors()) {
            ModelAndView view = new ModelAndView("index");
            Map<String, String> gender = new HashMap<>();
            gender.put("male", "MALE");
            gender.put("female", "FEMALE");

            Map<String, String> country = new HashMap<>();
            country.put("india", "INDIA");
            country.put("usa", "USA");
            country.put("canada", "CANADA");
            country.put("nepal", "NEPAL");

            view.addObject("country", country);
            view.addObject("gender", gender);
            view.addObject("user", model);
            return view;
        }
        return modelAndView;
    }
}
