package com.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {


    @RequestMapping(value = "home")
    public String test(){

        System.out.println("Checking Out");

        System.out.println("Second Test Branch");

        return "test";
    }
}
