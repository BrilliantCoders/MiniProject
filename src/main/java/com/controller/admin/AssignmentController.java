package com.controller.admin;

import com.database.AssignmentDAO;
import com.model.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class AssignmentController {

    @Autowired
    AssignmentDAO dao;

    @RequestMapping(value = "assignment")
    public String assignment(Model m){
        Assignment asgn=new Assignment();
        m.addAttribute("assignment",asgn);
        return "admin/UploadAssignment";
    }

    @RequestMapping(value = "uploadAssignment")
    public String uploadAssignment(Assignment asgn, @RequestParam("file") CommonsMultipartFile file, HttpSession session, HttpServletRequest req) {
        System.out.println(req.getRequestURI());
        String dates=(String) req.getParameter("date");

        System.out.println(dates);

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date date=null;
        try {
            date = (Date)formatter.parse(dates);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        String path = session.getServletContext().getRealPath("/");
        String filename = file.getOriginalFilename();

        System.out.println(path + " " + filename);
        asgn.setEndDate(date);
        asgn.setStartDate(asgn.getEndDate());
        asgn.setAssgnLink(filename);

        try {
            byte barr[] = file.getBytes();

            BufferedOutputStream bout = new BufferedOutputStream(
                    new FileOutputStream(path + "/" + filename));
            bout.write(barr);
            bout.flush();
            bout.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        dao.upload(asgn);
        return "admin/AttendanceSuccess";
    }

    @RequestMapping(value = "viewAssignment")
    public String viewAssignment(Model m){
        List<Assignment> list=dao.getAssignmentList();
        m.addAttribute("assgnList",list);
        return "admin/ViewAssignments";
    }

}
