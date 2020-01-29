package com.database;

import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

public class CourseDAO {

    @Autowired
    JdbcTemplate template;

    public void addCourseStudent(ArrayList<Student> students){

        String query;

        query="CREATE TABLE ds_mca_second_student (" +
                "  RegNo VARCHAR(45) NOT NULL," +
                "  RollNo INTEGER UNSIGNED NOT NULL," +
                "  Name VARCHAR(45) NOT NULL," +
                "  Email VARCHAR(45) NOT NULL," +
                "  Password VARCHAR(45) NOT NULL," +
                "  PRIMARY KEY (`RegNo`)" +
                ")";

        template.update(query);

        query="CREATE TABLE ds_mca_second_attendance (" +
                "  RegNo VARCHAR(45) NOT NULL," +
                "  RollNo INTEGER UNSIGNED NOT NULL," +
                "  PRIMARY KEY (`RegNo`)" +
                ")";

        template.update(query);



        int count=0;
        for (Student st:students){
            query="insert into ds_mca_second_student values( '"+st.getRegNo()+"' , "+st.getRollNo()+" , '"+st.getName()+"'" +
                    " ,'"+st.getEmail()+"' ,'"+st.getPassword()+"');";
            template.update(query);

            query="insert into ds_mca_second_attendance values( '"+st.getRegNo()+"' , "+st.getRollNo()+" );";
            template.update(query);

            System.out.println("uploaded "+count+" student data");
        }


    }


}
