package com.controller.admin;

import com.database.AttendanceDAO;
import com.model.Notice;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Controller
public class StudentPerformanceDetailController {

    @Autowired
    AttendanceDAO dao;



    @RequestMapping(value = "studentPerformanceDetail/{id}")
    public String deleteNotice(@PathVariable("id") String id, Model m, HttpServletRequest req){
        //m.addAttribute("Notices",list);
        return "admin/StudentPerformanceDetail";
    }

    @RequestMapping(value = "studentList")
    public String showStudentList(Model m){

        List<Student> list=dao.getStudentList();
        Collections.sort(list);

        m.addAttribute("Students",list);
        return "admin/StudentPerformanceList";
    }
}
