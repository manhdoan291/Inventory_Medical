package com.java1906.climan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloTemplateController {
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("titleWebsite", "Java1906 Website");
        return "login";
    }
}
