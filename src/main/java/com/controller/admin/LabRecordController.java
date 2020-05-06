package com.controller.admin;

import com.database.LabRecordDAO;
import com.helper.ExcelFileHelper;
import com.helper.LabRecordHelper;
import com.model.LabMarks;
import com.model.Student;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@Controller
public class LabRecordController {

    @Autowired
    ExcelFileHelper helper;
    @Autowired
    LabRecordHelper labRecordHelper;

    @Autowired
    LabRecordDAO dao;

    @RequestMapping(value = "/admin/uploadLabRecord")
    public String uploadAttendance(Model m){

        return "admin/UploadLabRecordViaFile";
    }


    @RequestMapping(value = "/admin/uploadLabRecordViaFile")
    public String uploadLabRecordViaFile(Model m, @RequestParam("file") CommonsMultipartFile file, HttpSession session, HttpServletRequest req) {
        ArrayList<LabMarks> list=new ArrayList<LabMarks>();
        ArrayList<String> headers=new ArrayList<String>();
        try {
            Sheet sheet=  helper.getExcelSheet(file);
            headers=helper.getHeaderFromExcelSheet(sheet);
            list=labRecordHelper.getListFromFile(sheet);

        } catch (IOException e) {
            e.printStackTrace();
        }
        m.addAttribute("LabMarksHeader", headers);
        m.addAttribute("LabMarksList", list);
        req.getSession().setAttribute("LabMarksHeader",headers);
        req.getSession().setAttribute("LabMarksList",list);

        return "admin/ShowLabRecordExcelPreview";
    }


    @RequestMapping(value = "/admin/submitLabRecordViaFile")
    public String submitAttendanceViaFile(Model m, HttpServletRequest request){
        ArrayList<LabMarks> list= (ArrayList<LabMarks>) request.getSession().getAttribute("LabMarksList");
        ArrayList<String> header=(ArrayList<String>) request.getSession().getAttribute("LabMarksHeader");



        dao.uploadMarksViaList(header,list);
        return "admin/AttendanceSuccess";
    }

}
