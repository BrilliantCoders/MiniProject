package com.controller.admin;

import com.helper.GlobalVariables;
import com.helper.MailHelper;
import com.model.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class DashBoardController {

    @Autowired
    MailHelper mailHelper;

    @RequestMapping(value = "/admin/dashboard")
    public String test(Model m, HttpServletRequest request){

        //GlobalVariables.setCourse((String) request.getSession().getAttribute("course"));

        ArrayList<Feature> list=new ArrayList<Feature>();
        String path="/resources/image";
        list.add(new Feature("Upload <br> Attendance","admin/uploadAttendance","/resources/image/uploaddoc.ico"));
        list.add(new Feature("Mark <br> Attendance","admin/attendanceList","/resources/image/atten.png"));
        list.add(new Feature("Performance <br> Record","admin/studentList","/resources/image/per.png"));
        list.add(new Feature("Teaching <br> Material","admin/addMaterial","/resources/image/teaching_material.png"));
        list.add(new Feature("Upload Lab <br> Record","admin/uploadLabRecord","/resources/image/lab.png"));
        list.add(new Feature("Upload New Notice","admin/addNotice","/resources/image/notify2.png"));
        list.add(new Feature("Add <br> Course","admin/addRemoveCourse","/resources/image/assgn.png"));
        list.add(new Feature("Show <br> Course","admin/showCourses","/resources/image/assgn.png"));
        list.add(new Feature("View <br> Assignments","admin/viewAssignment","/resources/image/assgn2.png"));
        list.add(new Feature("Upload <br> Assignment","admin/assignment","/resources/image/upload.png"));
        list.add(new Feature("Upload <br> Quiz","admin/uploadQuiz","/resources/image/chgpass.png"));
        list.add(new Feature("Show Notices","admin/showNotice","/resources/image/notify2.png"));
        list.add(new Feature("Show <br> Material","admin/showMaterial","/resources/image/teaching_material.png"));
        list.add(new Feature("Attendance <br> History","admin/showAttendance","/resources/image/atten.png"));
        list.add(new Feature("Logout <br> Website","admin/logout","/resources/image/logout.png"));


        m.addAttribute("features",list);


        return "admin/AdminDashBoard";
    }
}

