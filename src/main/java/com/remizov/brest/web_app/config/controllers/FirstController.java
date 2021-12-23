package com.remizov.brest.web_app.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/say")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println( name +" "+surname.toUpperCase());

        return("first/hello");
    }

    @GetMapping ("/goodbye")
    public String goodByePage(@RequestParam(value = "name",required = false)String name){
        System.out.println("Bye, " + name);
        return("first/goodbye");
    }
}
