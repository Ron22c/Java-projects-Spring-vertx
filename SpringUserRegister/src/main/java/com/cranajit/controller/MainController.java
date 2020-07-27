package com.cranajit.controller;

import com.cranajit.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        User model = new User();

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
}
