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
        list.add(new Feature("Mark","attendanceList","/image/attendanceIcon.png"));
        list.add(new Feature("Mark","attendance","https://cdn2.iconfinder.com/data/icons/flat-colored-2/130/194-512.png"));
        list.add(new Feature("Mark","/attendance","https://cdn2.iconfinder.com/data/icons/flat-colored-2/130/194-512.png"));
        list.add(new Feature("Mark","/attendance","https://cdn2.iconfinder.com/data/icons/flat-colored-2/130/194-512.png"));
        list.add(new Feature("Mark","/attendance","WEB-INF/image/attendanceIcon.png"));
        m.addAttribute("features",list);


        return "admin/AdminDashBoard";
    }
}

