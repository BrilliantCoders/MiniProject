package com.controller.user;

import com.database.UserQuizDAO;
import com.model.Question;
import com.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class QuizUserController {

    @Autowired
    UserQuizDAO dao;

    @RequestMapping(value = "showQuestions")
    public String showQuestions(Model m, @RequestParam("quizId") int quizId,@RequestParam("duration") int duration){
        List<Question> list=dao.getQuestionList(quizId);

        m.addAttribute("duration",duration);
        m.addAttribute("questionList",list);
        return "user.ShowQuiz";

    }

    @RequestMapping(value = "showQuiz")
    public String showQuiz(Model m){
        List<Quiz> list=dao.getQuizList();
        m.addAttribute("quizList",list);
        return "user.RegisterQuiz";

    }


}
