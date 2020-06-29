package com.controller.user;

import com.database.NoticeDAO;
import com.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserNoticeController {

    @Autowired
    NoticeDAO dao;

    @RequestMapping(value = "/user/showUserNotice")
    public String showUserNotice(Model m, HttpServletRequest req){

        List<Notice> list=dao.showNotice();
        m.addAttribute("Notices",list);
        return "user/showUserNotice";
    }
}
