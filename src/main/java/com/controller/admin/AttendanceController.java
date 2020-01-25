package com.controller.admin;

import com.database.AttendanceDAO;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AttendanceController {

    @Autowired
    AttendanceDAO dao;

    @RequestMapping(value = "attendanceList")
    public String showStudentList(Model m){
        List<Student> list=dao.getStudentList();
        m.addAttribute("Students",list);
        return "admin/ShowStudentList";
    }

}
