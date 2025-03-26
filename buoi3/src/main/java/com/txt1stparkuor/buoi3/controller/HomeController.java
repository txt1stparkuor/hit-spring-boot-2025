package com.txt1stparkuor.buoi3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home (Model model) {
        model.addAttribute("name", "duy");
        return "index";
    }
}
