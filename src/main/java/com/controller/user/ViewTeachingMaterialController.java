package com.controller.user;

import com.database.ViewTeachingMaterialDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewTeachingMaterialController {

    @Autowired
    ViewTeachingMaterialDAO dao;

    @RequestMapping(value = "viewMaterial")
    public String viewMaterial(){
        return "user/viewTeachingMaterial";
    }

}
