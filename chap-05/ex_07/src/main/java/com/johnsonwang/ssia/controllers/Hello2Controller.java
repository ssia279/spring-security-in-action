package com.johnsonwang.ssia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello2Controller {

    @GetMapping("/home")
    public String home() {
        return "home.html";
    }
}
