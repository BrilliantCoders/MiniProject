package com.controller.admin;

import com.database.AdminLoginDAO;
import com.model.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {


    @Autowired
    AdminLoginDAO dao;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model m,HttpServletRequest request) {

        if(request.getSession().getAttribute("type")==null){
            return "admin/test";
        }

        String type=(String)request.getSession().getAttribute("type");
        System.out.println("Mytype "+type);
        if(type.equals("admin")){
            ArrayList<Feature> list=new ArrayList<Feature>();
            String path="/resources/image";
            list.add(new Feature("Upload\nAttendance","admin/uploadAttendance","/resources/image/uploaddoc.ico"));
            list.add(new Feature("Mark\nAttendance","admin/attendanceList","/resources/image/atten.png"));
            list.add(new Feature("Performance\nRecord","admin/studentList","/resources/image/per.png"));
            list.add(new Feature("Teaching\nMaterial","admin/addMaterial","/resources/image/teaching_material.png"));
            list.add(new Feature("Upload Lab\nRecord","admin/uploadLabRecord","/resources/image/lab.png"));
            list.add(new Feature("Upload New Notice","admin/addNotice","/resources/image/notify2.png"));
            list.add(new Feature("Add\nCourse","admin/addRemoveCourse","/resources/image/assgn.png"));
            list.add(new Feature("Show\nCourse","admin/showCourses","/resources/image/assgn.png"));
            list.add(new Feature("View\nAssignments","admin/viewAssignment","/resources/image/assgn2.png"));
            list.add(new Feature("Upload\nAssignment","admin/assignment","/resources/image/upload.png"));

            list.add(new Feature("Upload\nQuiz","admin/uploadQuiz","/resources/image/chgpass.png"));

            list.add(new Feature("Logout\nWebsite","/attendance","/resources/image/logout.png"));


            m.addAttribute("features",list);


            return "admin/AdminDashBoard";
        }
        else if(type.equals("user")){
            return "user/AttendanceSuccess";
        }

        return "admin/test";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String adlogin(Model model,HttpServletRequest request) {
        List<String> list=dao.getAllCourses();
        //model.addAttribute("Courses",list);
        return "admin/test";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String init(Model model,HttpServletRequest request) {
        List<String> list=dao.getAllCourses();


        model.addAttribute("Courses",list);
        return "admin/AdminLogin";
    }

    @RequestMapping(value = "/admin/subLogin")
    public String submit(Model m, @ModelAttribute("Username") String userName,@ModelAttribute("Password") String password) {
        /*
        System.out.println("My Username is "+userName+"  Password is "+password);

        boolean isLogin = dao.authenticate(userName,password);

        if(isLogin==true) {
       */
            ArrayList<Feature> list=new ArrayList<Feature>();
            String path="/resources/image";
            list.add(new Feature("Mark\nAttendance","attendanceList","/resources/image/atten.png"));
            list.add(new Feature("Performance\nRecord","/attendance","/resources/image/per.png"));
            list.add(new Feature("Teaching\nMaterial","attendanceList","/resources/image/teaching_material.png"));
            list.add(new Feature("Laboratory\nRecord","attendance","/resources/image/lab.png"));
            list.add(new Feature("Upload New Notice","attendance","/resources/image/notify2.png"));
            list.add(new Feature("Change\nPassword","/attendance","/resources/image/chgpass.png"));
            list.add(new Feature("Upload\nAssignment","/attendance","/resources/image/upload.png"));
            list.add(new Feature("See\nAssignments","/attendance","/resources/image/assgn2.png"));
            list.add(new Feature("Add/Remove\nCourse","addRemoveCourse","/resources/image/assgn.png"));
            list.add(new Feature("Logout\nWebsite","/attendance","/resources/image/logout.png"));


            m.addAttribute("features",list);



            return "admin/AdminDashBoard";
  /*      }
        else
            return "admin/AdminLogin";
  */  }




    @RequestMapping(value="/admin/logout", method= RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "admin/UploadQuiz";
    }
}