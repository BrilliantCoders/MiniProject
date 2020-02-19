package com.database;

import com.model.Question;
import com.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserQuizDAO {

    @Autowired
    JdbcTemplate template;

    public List<Question> getQuestionList(int quizId){
        List<Question> list=new ArrayList<Question>();

        String query="select Id, Question, Option1, Option2, Option3, Option4, Answer from ds_mca_second_quiz_"+quizId+";";
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

                return ob;
            }
        });
        return list;
    }

    public List<Quiz> getQuizList(){
        List<Quiz> list=new ArrayList<Quiz>();
        String query="select * from quizzes where Course='ds_mca_second'";
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

}
