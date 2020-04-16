package com.java1906.demointerceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;

@Controller
public class HelloTemplateController {
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("titleWebsite", "Java1906 Website");
        return "login";
    }
}
