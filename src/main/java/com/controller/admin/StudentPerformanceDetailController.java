package com.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentPerformanceDetailController {

    @RequestMapping(value = "studentPerformanceDetail")
    public String studentPerformanceDetail(){
        return "admin/StudentPerformanceDetail";
    }
}
