package com.remizov.brest.web_app.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/end")
public class SecondController {

    @GetMapping("/exit")
    public String exit(){
        return ("second/go_home");
    }

}
