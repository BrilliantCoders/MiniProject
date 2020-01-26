package com.database;

import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttendanceDAO {
    @Autowired
    JdbcTemplate template;
    List<Student> list=null;
    public List<Student> getStudentList(){

        if(list!=null)
            return list;

        list=new ArrayList<Student>();
        String query="select * from ds_mca_second_student;";
        list=  template.query(query, new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student ob=new Student();
                ob.setName(resultSet.getString("Name"));
                ob.setEmail(resultSet.getString("Email"));
                ob.setRegNo(resultSet.getString("RegNo"));
                ob.setRollNo(resultSet.getInt("RollNo"));
                return ob;
            }
        });

        return list;

    }

    public void markAttendance(String date,String absentees){

        // check if column exist or not
       /* String query="select "+date+" from ALL_TAB_COLUMNS where TABLE_NAME = 'ds_mca_second_student'";
        template.query(query);*/
        String query;
        query="Alter table ds_mca_second_attendance add column "+date+" VARCHAR(45) NOT NULL DEFAULT 'P'";
        int x=0;//template.update(query);
        String ab="";
        String[] absenteesList=absentees.split(",");
        for (String s:absenteesList) {
            ab+="'"+s+"',";
        }
        ab=ab.substring(0,ab.length()-1);
        query="update ds_mca_second_attendance set "+date+"='P';";
        template.update(query);
        query="update ds_mca_second_attendance set "+date+"='A' where RegNo in ("+ab+");";
        int y=template.update(query);
        System.out.println(x+"   "+y);
    }


}
