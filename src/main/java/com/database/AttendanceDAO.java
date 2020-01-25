package com.database;

import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

}
