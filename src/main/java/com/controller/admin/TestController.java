package com.controller.admin;

import com.helper.MailHelper;
import org.simplejavamail.mailer.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @Autowired
    MailHelper mailHelper;

    @RequestMapping(value = "test")
    public String test(){

        mailHelper.send();
        System.out.println("Checking Out");

        System.out.println("Second Test Branch");

        return "test";
    }
}

