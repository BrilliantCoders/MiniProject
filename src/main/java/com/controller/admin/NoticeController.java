package com.controller.admin;

import com.database.NoticeDAO;
import com.model.Notice;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    NoticeDAO dao;

    @RequestMapping(value = "addNotice")
    public String addNotice(){
        return "admin/UploadNotice";
    }

    @RequestMapping(value = "uploadNotice")
    public String uploadNotice( HttpSession session, HttpServletRequest req){
        SimpleDateFormat formatter = new SimpleDateFormat("EEE_MMM_dd_00_00_00_zzz_yyyy");

        dao.insertNotice((String)req.getParameter("name"),(String)req.getParameter("desc"));
        return "admin/AdminDashBoard";
    }

    @RequestMapping(value = "showNotice")
    public String showNotice(Model m, HttpServletRequest req){

        List<Notice> list=dao.showNotice();
        m.addAttribute("Notices",list);
        return "admin/ShowNotice";
    }
    @RequestMapping(value = "showUserNotice")
    public String showUserNotice(Model m, HttpServletRequest req){

        List<Notice> list=dao.showNotice();
        m.addAttribute("Notices",list);
        return "user/showUserNotice";
    }


    @RequestMapping(value = "deleteNotice/{id}")
    public String deleteNotice(@PathVariable("id") String id,Model m, HttpServletRequest req){
        dao.remove( Integer.parseInt(id));
        List<Notice> list=dao.showNotice();
        m.addAttribute("Notices",list);
        return "admin/ShowNotice";
    }


    @RequestMapping(value = "showNoticeVisitedStudents/{id}")
    public String showNoticeVisitedStudents(@PathVariable("id") String id,Model m, HttpServletRequest req){
        Timestamp d=dao.getNoticeUploadDate(Integer.parseInt(id));
        List<Student> list=dao.getStudentList(d);
        m.addAttribute("Students",list);
        return "admin/ShowVisitedStudentList";
    }


}
