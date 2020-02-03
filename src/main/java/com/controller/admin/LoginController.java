package com.controller.admin;

import com.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value = "/AdminLogin", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "AdminLogin";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("Login") Login Login) {
        if (Login != null && Login.getUsername() != null & Login.getPassword() != null) {
            if (Login.getUsername().equals("yash") && Login.getPassword().equals("yash")) {
                model.addAttribute("msg", Login.getUsername());
                return "AdminDashBoard";
            } else {
                model.addAttribute("error", "Invalid Details");
                return "AdminLogin";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "AdminLogin";
        }
    }
}