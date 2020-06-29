package com.controller.user;

import com.database.ViewTeachingMaterialDAO;
import com.model.Assignment;
import com.model.TeachingMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class ViewTeachingMaterialController {

    @Autowired
    ViewTeachingMaterialDAO dao;

    @RequestMapping(value = "/user/viewMaterial")
    public String viewMaterial() {
        return "user/viewTeachingMaterial";
    }

    @RequestMapping(value = "/user/fetchMaterial")
    public ModelAndView listDetail(ModelAndView model) throws IOException {
        List<TeachingMaterial> listDet =dao.getMaterialList();
        model.addObject("listDet", listDet);
        model.setViewName("user/viewTeachingMaterial");

        return  model;
    }

}
