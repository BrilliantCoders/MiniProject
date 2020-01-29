package com.controller.admin;

import com.helper.ExcelFileHelper;
import com.model.Student;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class CourseController {
    @Autowired
    ExcelFileHelper helper;

    @RequestMapping(value = "addRemoveCourse")
    public String addRemoveCourse(Model m){

        return "admin/AddRemoveCourse";

    }


    @RequestMapping(value = "uploadCourse")
    public String uploadCourse(Model m,@RequestParam("file") CommonsMultipartFile file){
        ArrayList<Student> list=new ArrayList<Student>();
        try {
            Sheet sheet=  helper.getExcelSheet(file);
            list=helper.getStudentListFromExcelSheet(sheet);

        } catch (IOException e) {
            e.printStackTrace();
        }
        m.addAttribute("StudentList", list);

        return "admin/ShowCourseRegisteredStudent";

    }

}
