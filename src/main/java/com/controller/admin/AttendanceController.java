package com.controller.admin;

import com.database.AttendanceDAO;
import com.helper.MailHelper;
import com.model.Student;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.*;

@Controller
public class AttendanceController {

    @Autowired
    AttendanceDAO dao;

    @Autowired
    MailHelper helper;

    @RequestMapping(value = "/admin/attendanceList")
    public String showStudentList(Model m){


        List<Student> list=dao.getStudentList();
        //Collections.sort(list);

        m.addAttribute("Students",list);
        return "admin/ShowStudentList";
    }


    @RequestMapping(value = "/admin/uploadAttendance")
    public String uploadAttendance(Model m){

        return "admin/UploadAttendance";
    }

    @RequestMapping(value = "/admin/submitAttendance")
    public String submitAttendance(Model m, @RequestParam ("absent") String absent){
        SimpleDateFormat formatter = new SimpleDateFormat("EEE_MMM_dd_00_00_00_zzz_yyyy");
        Date date = new Date();
        String dt=formatter.format(date);

        dao.markAttendance(dt,absent);

        return "admin/AttendanceSuccess";
    }


    @RequestMapping(value = "/admin/submitAttendanceViaFile")
    public String submitAttendanceViaFile(Model m, HttpServletRequest request){
        ArrayList<Student> list= (ArrayList<Student>) request.getSession().getAttribute("AttendanceList");
        ArrayList<String> header=(ArrayList<String>) request.getSession().getAttribute("AttendanceHeader");



        dao.markAttendanceViaList(header,list);
        return "admin/AttendanceSuccess";
    }


    @RequestMapping(value = "/admin/showAttendance")
    public String showAttendance(Model m, HttpSession session, HttpServletRequest req) {


        List<Student> list=new ArrayList<Student>();
        List<String> headers=new ArrayList<String>();
        headers=dao.getAttendanceHeader();
        list=dao.getAttendance();
        Collections.sort(list);

        m.addAttribute("AttendanceHeader", headers);
        m.addAttribute("AttendanceList", list);
        req.getSession().setAttribute("AttendanceList",list);
        req.getSession().setAttribute("AttendanceHeader",headers);
        System.out.println(list.size()+" q"+headers.get(0));
        return "admin/ShowAllPreviousAttendance";
    }

}
