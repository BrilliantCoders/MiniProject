package com.controller.admin;

import com.database.TeachingMaterialDAO;
import com.helper.FileUploadHelper;
import com.helper.MailHelper;
import com.model.TeachingMaterial;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class TeachingMaterialController {

    @Autowired
    FileUploadHelper fileUploadHelper;

    @Autowired
    TeachingMaterialDAO dao;

    @Autowired
    MailHelper helper;

    @RequestMapping(value = "/admin/addMaterial")
    public String addMaterial(){
        return "admin/UploadTeachingMaterial";
    }

    @RequestMapping(value = "/admin/uploadMaterial")
    public String uploadMaterial(@RequestParam("file") CommonsMultipartFile file, HttpSession session, HttpServletRequest req){
        fileUploadHelper.uploadFile(file,session);
        String filename = file.getOriginalFilename();

        dao.insertMaterial((String)req.getParameter("name"),(String)req.getParameter("desc"),filename);
        helper.sendMail("New Teaching Material Uploaded","Hello Everyone , A teaching material has been uploaded to the portal");
        return "admin/AttendanceSuccess";
    }

    @RequestMapping(value = "/admin/showMaterial")
    public String showTeachingMaterial(Model m, HttpServletRequest req){

        List<TeachingMaterial> list=dao.showMaterial();
        m.addAttribute("TeachingMaterials",list);
        return "admin/ShowTeachingMaterial";
    }



    @RequestMapping(value = "/admin/deleteMaterial/{id}")
    public String deleteTeachingMaterial(@PathVariable("id") String id, Model m, HttpServletRequest req){
        dao.remove( Integer.parseInt(id));
        List<TeachingMaterial> list=dao.showMaterial();
        m.addAttribute("TeachingMaterials",list);
        return "admin/ShowTeachingMaterial";
    }


    @RequestMapping(value = "/admin/showMaterialVisitedStudents/{id}")
    public String showTeachingMaterialVisitedStudents(@PathVariable("id") String id,Model m, HttpServletRequest req){
        Timestamp d=dao.getTeachingMaterialUploadDate(Integer.parseInt(id));
        List<Student> list=dao.getStudentList(d);
        m.addAttribute("Students",list);
        return "admin/ShowVisitedStudentList";
    }



}
