package com.database;

import com.model.Question;
import com.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class QuizDAO {

    @Autowired
    JdbcTemplate template;

    public void uploadQuiz(Quiz quiz,List<Question> questions){
        Timestamp sdate = new Timestamp(quiz.getStartDateTime().getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp edate = new Timestamp(quiz.getEndDateTime().getTime());

        String query="insert into quizzes ( QuizName, StartDateTime, EndDateTime, Duration, Course) values (" +
                "  '"+quiz.getQuizName()+"','"+formatter.format(sdate)+"','"+formatter.format(edate)+"'" +
                ","+quiz.getDuration()+",'ds_mca_second');";

        template.update(query);
        uploadQuestions(questions,1);

    }

    public void uploadQuestions(final List<Question> questions, int QuizId){

        String query="CREATE TABLE ds_mca_second_quiz_1 (\n" +
                "  `Id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
                "  `Question` LONGTEXT NOT NULL,\n" +
                "  `Option1` TEXT NOT NULL,\n" +
                "  `Option2` TEXT NOT NULL,\n" +
                "  `Option3` TEXT NOT NULL,\n" +
                "  `Option4` TEXT NOT NULL,\n" +
                "  `Answer` INTEGER SIGNED NOT NULL,\n" +
                "  `Explanation` LONGTEXT ,\n" +
                "  PRIMARY KEY (`Id`)\n" +
                ")";

        template.update(query);
        query="insert into ds_mca_second_quiz_1 (Question,Option1,Option2,Option3,Option4,Answer,Explanation) values (?,?,?,?,?,?,?)";

        template.batchUpdate(query, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                  Question q=questions.get(i);
                  preparedStatement.setString(1,q.getQuestion());
                preparedStatement.setString(2,q.getOption1());
                preparedStatement.setString(3,q.getOption2());
                preparedStatement.setString(4,q.getOption3());
                preparedStatement.setString(5,q.getOption4());
                preparedStatement.setInt(6,q.getAnswer());
                preparedStatement.setString(7,q.getExpanation());
            }

            public int getBatchSize() {
                return questions.size();
            }
        });


    }

}
