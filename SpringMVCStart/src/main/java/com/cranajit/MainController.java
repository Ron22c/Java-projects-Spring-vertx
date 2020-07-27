package com.cranajit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String welcome() {
        return "index";
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
//    public String name(HttpServletRequest request) {
    public String name(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "name";
    }
}
