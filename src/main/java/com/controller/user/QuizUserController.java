package com.controller.user;

import com.database.UserQuizDAO;
import com.helper.GlobalVariables;
import com.model.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class QuizUserController {

    @Autowired
    UserQuizDAO dao;

    @RequestMapping(value = "/user/showQuestions")
    public String showQuestions(Model m, HttpServletRequest request, @RequestParam("quizId") int quizId, @RequestParam("duration") int duration){
        System.out.println("id "+quizId);
        List<Question> list=dao.getQuestionList(quizId);

        request.getSession().setAttribute("quizid",quizId);

        QuestionListWrapper wrapper=new QuestionListWrapper();
        wrapper.setQuestionList(list);

        m.addAttribute("duration",duration);
        //m.addAttribute("questionList",list);
        m.addAttribute("questionListWrapper",wrapper);
        return "user.ShowQuiz";

    }

    @RequestMapping(value = "/user/showResult/{id}")
    public String showQuizResult(@PathVariable("id") String id, Model m, HttpServletRequest req){
        List<QuizResult> list=dao.getQuizResult(id);

        m.addAttribute("QuizResult",list);
        return "user/ShowQuizResult";
    }


    @RequestMapping(value = "/user/showQuiz")
    public String showQuiz(Model m){
        List<Quiz> list=dao.getQuizList();
        m.addAttribute("quizList",list);
        return "user.RegisterQuiz";

    }


    @RequestMapping(value = "/user/submitResponses")
    public String submitResponses(Model m, QuestionListWrapper wrapper, HttpSession session,HttpServletRequest request){
        List<Question> list=wrapper.getQuestionList();
        System.out.println(list.size());
        m.addAttribute("questionList",list);
        session.setAttribute("questionList",list);

        int correct=0;
        int wrong=0;

        for(Question question:list){
            int ans=question.getUserAnswer();
            if(ans == question.getAnswer()){
                correct++;
            }
            else if(ans != -1){
                wrong++;
            }
        }


        int total=(correct*4)+(wrong*-1);
        double out=(list.size())*4;



        dao.setQuizResult("Quiz_"+request.getSession().getAttribute("quizid"),(total/out)*100);

      /*  PDDocument document = new PDDocument();
        PDPage page=new PDPage();
        document.addPage(page);
        try {


            document.addPage(page);
            PDFont font = PDType1Font.HELVETICA;
            PDPageContentStream content = new PDPageContentStream(document,page);

            content.beginText();
            content.setFont(font, 12);
            content.moveTextPositionByAmount(100, 700);
            String message = "";

            int lines=1;
            for (Question q:list) {



                content.drawString(q.getQuestion().replace("\n","").replace("\r",""));
                content.moveTextPositionByAmount(0,  700 - 20f * lines);

                lines++;
                *//*content.drawString(q.getOption1());
                content.moveTextPositionByAmount(0, 1);
                content.drawString(q.getOption2());
                content.moveTextPositionByAmount(0, 1);
                content.drawString(q.getOption3());
                content.moveTextPositionByAmount(0, 1);
                content.drawString(q.getOption4());
                content.moveTextPositionByAmount(0, 1);

                content.drawString(String.valueOf(q.getAnswer()));
                content.moveTextPositionByAmount(0, 1);

                content.drawString(String.valueOf(q.getUserAnswer()));
                content.moveTextPositionByAmount(0, 1);
*//*


            }



            content.endText();
            content.close();


            String path = session.getServletContext().getRealPath("/");
            document.save(path+"/BlankPdf.pdf");
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("PDF created");
*/

        return "user.QuizResult";
    }

    @RequestMapping(value = "/user/showResponses")
    public String showResponses(Model m,HttpSession session){
        List<Question> list= (List<Question>) session.getAttribute("questionList");
        m.addAttribute("questionList",list);
        return "user.ShowResponse";
    }


}
