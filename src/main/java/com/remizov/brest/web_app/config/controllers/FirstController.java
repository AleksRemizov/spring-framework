package com.remizov.brest.web_app.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String goodByePage(@RequestParam(value = "name",required = false)String name,
                              Model model){
        model.addAttribute("message","Hello " + name);
        return("first/goodbye");
    }
    @GetMapping ("/calculator")
    public String executeCalculate(@RequestParam("a") int a,
                                   @RequestParam("b")int b,
                                   @RequestParam("action")String action,
                                   Model model){
        double result ;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double) b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "addition":
                result = a + b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result",result);
        return("first/calculator");

    }
}
