package com.controller.user;

import com.database.AttendanceDAO;
import com.database.PerformanceDAO;
import com.helper.GlobalVariables;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class EachStudentPerformanceDetailController {

    @Autowired
    AttendanceDAO attendanceDAO;

    @Autowired
    PerformanceDAO dao;

    @RequestMapping(value = "/user/studentPerformanceDetail")
    public String deleteNotice( Model m, HttpServletRequest req){
        //m.addAttribute("Notices",list);

        List<Student> list=new ArrayList<Student>();
        List<String> headers=new ArrayList<String>();
        List<Integer> quizResult=new ArrayList<Integer>();
        headers=dao.getAttendanceHeader();
        list=dao.getAttendance();
        quizResult=dao.getQuizResult();
        Student student=dao.getStudentDetail();

        m.addAttribute("AttendanceHeader", headers);
        m.addAttribute("AttendanceList", list);
        m.addAttribute("QuizResult", quizResult);
        req.getSession().setAttribute("AttendanceList",list);
        req.getSession().setAttribute("AttendanceHeader",headers);
        req.getSession().setAttribute("QuizResult", quizResult);
        req.getSession().setAttribute("Student", student);
        return "admin/StudentPerformanceDetail";
    }


}
