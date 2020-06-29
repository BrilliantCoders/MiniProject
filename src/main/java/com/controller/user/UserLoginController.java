package com.controller.user;

import com.database.UserLoginDAO;
import com.helper.GlobalVariables;
import com.model.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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

           ArrayList<Feature> list=new ArrayList<Feature>();
            String path="/resources/image";
            list.add(new Feature("View Notice","/user/showUserNotice","/resources/image/atten.png"));
            list.add(new Feature("Performance\nRecord","/attendance","/resources/image/per.png"));
            list.add(new Feature("Teaching Material","/user/fetchMaterial","/resources/image/teaching_material.png"));
            list.add(new Feature("See\nAssignments","/user/fetch","/resources/image/assgn2.png"));
            list.add(new Feature("Show Quizzes","/user/showQuiz","/resources/image/assgn2.png"));
            list.add(new Feature("Logout\nWebsite","/attendance","/resources/image/logout.png"));

            m.addAttribute("features",list);

            return "user/UserDashBoard";

    }
}

