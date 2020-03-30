package com.controller.admin;

import com.database.NoticeDAO;
import com.database.TeachingMaterialDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

        dao.insertNotice((String)req.getParameter("name"),(String)req.getParameter("desc"));
        return "admin/AdminDashBoard";
    }


}
