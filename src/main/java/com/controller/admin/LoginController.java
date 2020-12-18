package com.controller.admin;

import com.database.AdminLoginDAO;
import com.database.UserLoginDAO;
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

    @Autowired
    UserLoginDAO userLoginDAO;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model m,HttpServletRequest request) {

        if(request.getSession().getAttribute("type")==null){
            return "admin/test";
        }

        String type=(String)request.getSession().getAttribute("type");
        if(type.equals("admin")){
            ArrayList<Feature> list=new ArrayList<Feature>();
            list.add(new Feature("Upload <br> Attendance","/admin/uploadAttendance","/resources/image/uploaddoc.ico"));
            list.add(new Feature("Mark <br> Attendance","/admin/attendanceList","/resources/image/atten.png"));
            list.add(new Feature("Attendance <br> History","/admin/showAttendance","/resources/image/atten.png"));

            list.add(new Feature("Performance <br> Record","/admin/studentList","/resources/image/per.png"));

            list.add(new Feature("Teaching <br> Material","/admin/addMaterial","/resources/image/teaching_material.png"));
            list.add(new Feature("Show <br> Material","/admin/showMaterial","/resources/image/teaching_material.png"));



            list.add(new Feature("Upload New Notice","/admin/addNotice","/resources/image/notify2.png"));
            list.add(new Feature("Show Notices","/admin/showNotice","/resources/image/notify2.png"));

            list.add(new Feature("Upload Lab <br> Record","/admin/uploadLabRecord","/resources/image/lab.png"));
            list.add(new Feature("View <br> Assignments","/admin/viewAssignment","/resources/image/assgn2.png"));
            list.add(new Feature("Upload <br> Assignment","/admin/assignment","/resources/image/upload.png"));


            list.add(new Feature("Add <br> Course","/admin/addRemoveCourse","/resources/image/assgn.png"));
            list.add(new Feature("Show <br> Course","/admin/showCourses","/resources/image/assgn.png"));

            list.add(new Feature("Upload <br> Quiz","/admin/uploadQuiz","/resources/image/chgpass.png"));
            list.add(new Feature("Show <br> Quizzes","/admin/showQuiz","/resources/image/chgpass.png"));

            list.add(new Feature("Logout <br> Website","/admin/logout","/resources/image/logout.png"));

            m.addAttribute("features",list);
            return "admin/AdminDashBoard";

            // done ok bro thank you so much yr sun

        }
        else if(type.equals("user")){

            userLoginDAO.updateLastVisit();

            ArrayList<Feature> list=new ArrayList<Feature>();
            list.add(new Feature("View <br> Notice","/user/showUserNotice","/resources/image/atten.png"));
            list.add(new Feature("Performance <br> Record","/user/studentPerformanceDetail","/resources/image/per.png"));
            list.add(new Feature("Teaching <br> Material","/user/fetchMaterial","/resources/image/teaching_material.png"));
            list.add(new Feature("See <br> Assignments","/user/fetch","/resources/image/assgn2.png"));
            list.add(new Feature("Show <br> Quizzes","/user/showQuiz","/resources/image/assgn.png"));
            list.add(new Feature("Logout <br> Website","/user/logout","/resources/image/logout.png"));
            m.addAttribute("features",list);
            return "user/UserDashBoard";
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

            ArrayList<Feature> list=new ArrayList<Feature>();
            String path="/resources/image";
            list.add(new Feature("Mark <br> Attendance","attendanceList","/resources/image/atten.png"));
            list.add(new Feature("Performance <br> Record","/attendance","/resources/image/per.png"));
            list.add(new Feature("Teaching <br> Material","attendanceList","/resources/image/teaching_material.png"));
            list.add(new Feature("Laboratory <br> Record","attendance","/resources/image/lab.png"));
            list.add(new Feature("Upload New Notice","attendance","/resources/image/notify2.png"));
            list.add(new Feature("Change <br> Password","/attendance","/resources/image/chgpass.png"));
            list.add(new Feature("Upload <br> Assignment","/attendance","/resources/image/upload.png"));
            list.add(new Feature("See <br> Assignments","/attendance","/resources/image/assgn2.png"));
            list.add(new Feature("Add/Remove <br> Course","addRemoveCourse","/resources/image/assgn.png"));
            list.add(new Feature("Logout <br> Website","/attendance","/resources/image/logout.png"));


            m.addAttribute("features",list);
            return "admin/AdminDashBoard";
    }




    @RequestMapping(value="/admin/logout", method= RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "admin/AdminLogin";
    }
}