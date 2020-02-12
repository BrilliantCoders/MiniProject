package com.controller.admin;

import com.helper.MailHelper;
import com.model.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class DashBoardController {

    @Autowired
    MailHelper mailHelper;

    @RequestMapping(value = "adminDashboard")
    public String test(Model m){


        ArrayList<Feature> list=new ArrayList<Feature>();
        String path="/resources/image";
        list.add(new Feature("Upload\nAttendance","uploadAttendance","/resources/image/uploaddoc.ico"));
        list.add(new Feature("Mark\nAttendance","attendanceList","/resources/image/atten.png"));
        list.add(new Feature("Performance\nRecord","/attendance","/resources/image/per.png"));
        list.add(new Feature("Teaching\nMaterial","attendanceList","/resources/image/teaching_material.png"));
        list.add(new Feature("Laboratory\nRecord","attendance","/resources/image/lab.png"));
        list.add(new Feature("Upload New Notice","attendance","/resources/image/notify2.png"));
        list.add(new Feature("Change\nPassword","/attendance","/resources/image/chgpass.png"));
        list.add(new Feature("Add/Remove\nCourse","addRemoveCourse","/resources/image/assgn.png"));
        list.add(new Feature("View\nAssignments","viewAssignment","/resources/image/assgn2.png"));
        list.add(new Feature("Upload\nAssignment","assignment","/resources/image/upload.png"));


        list.add(new Feature("Logout\nWebsite","/attendance","/resources/image/logout.png"));


        m.addAttribute("features",list);


        return "admin/AdminDashBoard";
    }
}

