package com.controller.admin;

import com.database.QuizDAO;
import com.helper.ExcelFileHelper;
import com.model.Question;
import com.model.Quiz;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class QuizController {

    @Autowired
    ExcelFileHelper helper;

    @Autowired
    QuizDAO dao;

    @RequestMapping(value = "/admin/uploadQuiz")
    public String uploadQuiz(Model m){
        Quiz quiz=new Quiz();
        m.addAttribute("quiz",quiz);
        return "admin/UploadQuiz";
    }




    @RequestMapping(value = "/admin/previewQuiz")
    public String upload(Model m, @RequestParam("file") CommonsMultipartFile file, Quiz quiz, HttpServletRequest req) {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date sdate=null,edate=null;
        try {
            sdate = (Date)formatter.parse(req.getParameter("sdate"));
            edate = (Date)formatter.parse(req.getParameter("edate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(sdate+" "+edate);
        quiz.setStartDateTime(sdate);
        quiz.setEndDateTime(edate);


        ArrayList<Question> list=new ArrayList<Question>();
        ArrayList<String> headers=new ArrayList<String>();
        try {
            Sheet sheet=  helper.getExcelSheet(file);
            //headers=helper.getHeaderFromExcelSheet(sheet);
            list=helper.getQuestionListFromExcelSheet(sheet);

        } catch (IOException e) {
            e.printStackTrace();
        }
        m.addAttribute("questionList", list);

        String invalid="";
        int  i=0;
        for (Question q:
             list) {
            i++;
            if(q.getAnswer()<1 || q.getAnswer()>4){
                invalid+=i+" ";
            }
        }

        m.addAttribute("invalid",invalid);
        req.getSession().setAttribute("questionList", list);
        req.getSession().setAttribute("quiz", quiz);

        return "admin/PreviewQuizQuestions";
    }


    @RequestMapping(value = "/admin/submitQuiz")
    public String submitQuiz(Model m, HttpServletRequest req){
        Quiz quiz= (Quiz) req.getSession().getAttribute("quiz");
        List<Question> questions= (List<Question>) req.getSession().getAttribute("questionList");
        dao.uploadQuiz(quiz,questions);
        return "admin/AttendanceSuccess";

    }

}
