package com.controller.user;

import com.database.UserLoginDAO;
import com.helper.GlobalVariables;
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
import java.util.List;

@Controller
public class UserLoginController {

    @Autowired
    UserLoginDAO dao;
    @RequestMapping(value = "/user/login")
    public String init(Model model,HttpServletRequest request){


        String course=(String) request.getAttribute("course");
        System.out.println(course);

        List<String> list=dao.getAllCourses();
        model.addAttribute("Courses",list);
        return "user/UserLogin";
    }

    @RequestMapping (value="/user/dashboard")
    public String submit(Model m, HttpServletRequest request){

           GlobalVariables.setCourse((String) request.getSession().getAttribute("course"));
           dao.updateLastVisit();

           ArrayList<Feature> list=new ArrayList<Feature>();
            list.add(new Feature("View <br> Notice","/user/showUserNotice","/resources/image/atten.png"));
            list.add(new Feature("Performance <br> Record","/user/studentPerformanceDetail","/resources/image/per.png"));
            list.add(new Feature("Teaching <br> Material","/user/fetchMaterial","/resources/image/teaching_material.png"));
            list.add(new Feature("See <br> Assignments","/user/fetch","/resources/image/assgn2.png"));
            list.add(new Feature("Show <br> Quizzes","/user/showQuiz","/resources/image/assgn2.png"));
            list.add(new Feature("Logout <br> Website","/user/logout","/resources/image/logout.png"));

            m.addAttribute("features",list);

            return "user/UserDashBoard";

    }


    @RequestMapping(value="/user/logout", method= RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "user/UserLogin";
    }
}

