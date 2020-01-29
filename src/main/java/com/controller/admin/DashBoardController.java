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
        list.add(new Feature("Mark Attendance","attendanceList","/resources/image/attendanceIcon.png"));
        list.add(new Feature("Notice Uploading","attendance","/resources/image/notice.png"));
        list.add(new Feature("Change Password","/attendance","/resources/image/changepassword.png"));
        list.add(new Feature("Performance Record","/attendance","/resources/image/reports.png"));
        list.add(new Feature("Logout Websiteee","/attendance","/resources/image/logout.png"));
        list.add(new Feature("Teaching Material","attendanceList","/resources/image/attendanceIcon.png"));
        list.add(new Feature("Laboratory Record","attendance","/resources/image/notice.png"));
        list.add(new Feature("Upload Assignment","/attendance","/resources/image/changepassword.png"));
        list.add(new Feature("See Assignments","/attendance","/resources/image/reports.png"));
        list.add(new Feature("Add/Remove Course","addRemoveCourse","/resources/image/logout.png"));

        m.addAttribute("features",list);


        return "admin/AdminDashBoard";
    }
}

