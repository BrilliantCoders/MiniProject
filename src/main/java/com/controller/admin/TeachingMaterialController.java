package com.controller.admin;

import com.database.TeachingMaterialDAO;
import com.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TeachingMaterialController {

    @Autowired
    FileUploadHelper fileUploadHelper;

    @Autowired
    TeachingMaterialDAO dao;

    @RequestMapping(value = "/admin/addMaterial")
    public String addMaterial(){
        return "admin/UploadTeachingMaterial";
    }

    @RequestMapping(value = "/admin/uploadMaterial")
    public String uploadMaterial(@RequestParam("file") CommonsMultipartFile file, HttpSession session, HttpServletRequest req){
        fileUploadHelper.uploadFile(file,session);
        String filename = file.getOriginalFilename();

        dao.insertMaterial((String)req.getParameter("name"),(String)req.getParameter("desc"),filename);
        return "admin/UploadTeachingMaterial";
    }


}
