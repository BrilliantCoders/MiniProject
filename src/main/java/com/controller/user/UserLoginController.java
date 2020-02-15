package com.controller.user;

import com.database.UserLoginDAO;
import com.model.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class UserLoginController {

    @Autowired
    UserLoginDAO dao;
    @RequestMapping(value="userLogin")
    public String init(Model model)
    {
        return "user/UserLogin";
    }

    @RequestMapping (value="submitLogin")
    public String submit(Model m, @ModelAttribute("StudentID") String userID,@ModelAttribute("StudentPassword") String userPassword){
        boolean isLogin = dao.authenticate(userID,userPassword);
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



            return "user/UserLogin";
        }

        else
            return "user/UserLogin";
    }
}

