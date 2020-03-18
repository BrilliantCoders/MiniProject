package com.controller.admin;

import com.database.AttendanceDAO;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class AttendanceController {

    @Autowired
    AttendanceDAO dao;

    @RequestMapping(value = "attendanceList")
    public String showStudentList(Model m){


        List<Student> list=dao.getStudentList();
        Collections.sort(list);

        m.addAttribute("Students",list);
        return "admin/ShowStudentList";
    }


    @RequestMapping(value = "uploadAttendance")
    public String uploadAttendance(Model m){

        return "admin/UploadAttendance";
    }

    @RequestMapping(value = "submitAttendance")
    public String submitAttendance(Model m, @RequestParam ("absent") String absent){
        SimpleDateFormat formatter = new SimpleDateFormat("EEE_MMM_dd_00_00_00_zzz_yyyy");
        Date date = new Date();
        String dt=formatter.format(date);

        dao.markAttendance(dt,absent);
        return "admin/AttendanceSuccess";
    }


    @RequestMapping(value = "submitAttendanceViaFile")
    public String submitAttendanceViaFile(Model m, HttpServletRequest request){
        ArrayList<Student> list= (ArrayList<Student>) request.getSession().getAttribute("AttendanceList");
        ArrayList<String> header=(ArrayList<String>) request.getSession().getAttribute("AttendanceHeader");



        dao.markAttendanceViaList(header,list);
        return "admin/AttendanceSuccess";
    }

}
