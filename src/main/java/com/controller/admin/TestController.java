package com.controller.admin;

import com.helper.MailHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @Autowired
    MailHelper mailHelper;

    @RequestMapping(value = "test")
    public String test(){

       // mailHelper.send();
        System.out.println("Checking Out");

        System.out.println("Second Test Branch");

        return "test";
    }


    @RequestMapping(value="inLogin")
    public String adminLogin(Model m){
        m.addAttribute("name","Rajat Kathuriya");
       // System.out.println("Login page called");
        return "AdminLogin";
    }


    @RequestMapping(value="submit")
    public String submit(@RequestParam ("email") String email){
        System.out.println("My Email is "+email);
        return "test";
    }

}

