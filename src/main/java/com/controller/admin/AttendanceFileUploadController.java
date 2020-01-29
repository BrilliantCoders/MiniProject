package com.controller.admin;

import com.helper.ExcelFileHelper;
import com.model.Student;
import org.apache.poi.hssf.OldExcelFormatException;
import org.apache.poi.hssf.extractor.OldExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;

@Controller
public class AttendanceFileUploadController {

    @Autowired
    ExcelFileHelper helper;

    @RequestMapping(value = "saveFile")
    public String upload(Model m, @RequestParam("file") CommonsMultipartFile file, HttpSession session, HttpServletRequest req) {


        ArrayList<Student> list=new ArrayList<Student>();
        ArrayList<String> headers=new ArrayList<String>();
        try {
            Sheet sheet=  helper.getExcelSheet(file);
            headers=helper.getHeaderFromExcelSheet(sheet);
            list=helper.getArrayFromExcelSheet(sheet);

        } catch (IOException e) {
            e.printStackTrace();
        }
        m.addAttribute("AttendanceHeader", headers);
        m.addAttribute("AttendanceList", list);
        req.getSession().setAttribute("AttendanceList",list);
        req.getSession().setAttribute("AttendanceHeader",headers);
        System.out.println(list.size()+" q"+headers.get(0));
        return "admin/ShowAttendanceExcelPreview";
    }





}

