package com.database;

import com.helper.GlobalVariables;
import com.model.Question;
import com.model.Quiz;
import com.model.QuizResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserQuizDAO {

    @Autowired
    JdbcTemplate template;

    

    public List<Question> getQuestionList(int quizId){
        List<Question> list=new ArrayList<Question>();

        String query="select Id, Question, Option1, Option2, Option3, Option4, Answer, Explanation from "+GlobalVariables.getCourse()+"_quiz_"+quizId+";";
        list=template.query(query, new RowMapper<Question>() {
            public Question mapRow(ResultSet resultSet, int i) throws SQLException {
                Question ob=new Question();
                //, Explanation
                ob.setId(resultSet.getInt("Id"));
                ob.setQuestion(resultSet.getString("Question"));
                ob.setOption1(resultSet.getString("Option1"));
                ob.setOption2(resultSet.getString("Option2"));
                ob.setOption3(resultSet.getString("Option3"));
                ob.setOption4(resultSet.getString("Option4"));
                ob.setAnswer(resultSet.getInt("Answer"));
                ob.setExpanation(resultSet.getString("Explanation"));
                return ob;
            }
        });
        return list;
    }

    public List<Quiz> getQuizList(){
        List<Quiz> list=new ArrayList<Quiz>();
        String query="select * from quizzes where Course='"+GlobalVariables.getCourse()+"'";
        final Date d=new Date();
        list=template.query(query, new RowMapper<Quiz>() {
            public Quiz mapRow(ResultSet resultSet, int i) throws SQLException {
                Quiz ob=new Quiz();
                ob.setId(resultSet.getInt("Id"));
                ob.setQuizName(resultSet.getString("QuizName"));
                ob.setStartDateTime(resultSet.getTimestamp("StartDateTime"));
                ob.setEndDateTime(resultSet.getTimestamp("EndDateTime"));
                ob.setDuration(resultSet.getInt("Duration"));

                if(ob.getStartDateTime().before(d) && ob.getEndDateTime().after(d) ){
                    ob.setActive(1);
                }
                else {
                    ob.setActive(0);
                }


                return ob;
            }
        });
        return list;
    }


    public void setQuizResult(String colName,double marks){
        String query="update "+GlobalVariables.getCourse()+"_quizresult set "+colName+" = '" +
                marks+"' where RegNo='"+GlobalVariables.getRegNo()+"'";
        template.update(query);
    }


    public List<QuizResult> getQuizResult(String quizId){
        List<QuizResult> list=new ArrayList<QuizResult>();
        String query="select Quiz_"+quizId+" as Marks,RollNo,Name from "+GlobalVariables.getCourse()+"_quizresult q, "+GlobalVariables.getCourse()+"_student s" +
                " where q.RegNo = s.RegNo and Quiz_"+quizId+"!=-1000 order by Marks desc";

        list=template.query(query, new RowMapper<QuizResult>() {
            public QuizResult mapRow(ResultSet resultSet, int i) throws SQLException {
                QuizResult ob=new QuizResult();
                ob.setName(resultSet.getString("Name"));
                ob.setRollNo(resultSet.getInt("RollNo"));
                ob.setMarks(resultSet.getDouble("Marks"));
                return ob;
            }
        });
        return list;
    }



}
