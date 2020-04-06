package com.controller.admin;

import com.database.CourseDAO;
import com.helper.ExcelFileHelper;
import com.model.Course;
import com.model.Student;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    ExcelFileHelper helper;

    @Autowired
    CourseDAO dao;

    @RequestMapping(value = "addRemoveCourse")
    public String addRemoveCourse(Model m){
        Course ob=new Course();
        m.addAttribute("course",ob);
        return "admin/AddRemoveCourse";

    }


    @RequestMapping(value = "uploadCourse")
    public String uploadCourse(Model m, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request,Course c){
        ArrayList<Student> list=new ArrayList<Student>();
        try {
            Sheet sheet=  helper.getExcelSheet(file);
            list=helper.getStudentListFromExcelSheet(sheet);

        } catch (IOException e) {
            e.printStackTrace();
        }
        m.addAttribute("StudentList", list);
        request.getSession().setAttribute("StudentList",list);
        request.getSession().setAttribute("Course",c);

        return "admin/ShowCourseRegisteredStudent";

    }


    @RequestMapping(value = "addCourseStudent")
    public String addCourseStudent(Model m,HttpServletRequest request){

        ArrayList<Student> list=(ArrayList<Student>) request.getSession().getAttribute("StudentList");
        Course c=(Course) request.getSession().getAttribute("Course");
        dao.addCourse(c);
        dao.addCourseStudent(list,c);
        return "admin/AttendanceSuccess";

    }

    @RequestMapping(value = "showCourses")
    public String showCourses(Model m,HttpServletRequest request) {
        List<Course> list=dao.showCourse();
        m.addAttribute("Courses",list);
        return "admin/ShowCourses";
    }


}
