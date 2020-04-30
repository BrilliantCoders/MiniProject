package com.controller.admin;

import com.database.AdminLoginDAO;
import com.model.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class LoginController {

    @Autowired
    AdminLoginDAO dao;
    @RequestMapping(value = "admin/login")
    public String init(Model model) {
        //1
        return "admin/AdminLogin";
    }

    @RequestMapping(value = "submitLogin")
    public String submit(Model m, @ModelAttribute("Username") String userName,@ModelAttribute("Password") String password) {
        //3
        System.out.println("My Username is "+userName+"  Password is "+password);

        boolean isLogin = dao.authenticate(userName,password);

        if(isLogin==true) {

            ArrayList<Feature> list=new ArrayList<Feature>();
            String path="/resources/image";
            list.add(new Feature("Mark\nAttendance","attendanceList","/resources/image/atten.png"));
            list.add(new Feature("Performance\nRecord","/attendance","/resources/image/per.png"));
            list.add(new Feature("Teaching\nMaterial","attendanceList","/resources/image/teaching_material.png"));
            list.add(new Feature("Laboratory\nRecord","attendance","/resources/image/lab.png"));
            list.add(new Feature("Upload New Notice","attendance","/resources/image/notify2.png"));
            list.add(new Feature("Change\nPassword","/attendance","/resources/image/chgpass.png"));
            list.add(new Feature("Upload\nAssignment","/attendance","/resources/image/upload.png"));
            list.add(new Feature("See\nAssignments","/attendance","/resources/image/assgn2.png"));
            list.add(new Feature("Add/Remove\nCourse","addRemoveCourse","/resources/image/assgn.png"));
            list.add(new Feature("Logout\nWebsite","/attendance","/resources/image/logout.png"));


            m.addAttribute("features",list);



            return "admin/AdminDashBoard";
        }
        else
            return "admin/AdminLogin";
    }




    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "admin/UploadQuiz";
    }
}