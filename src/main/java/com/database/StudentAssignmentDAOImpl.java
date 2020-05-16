package com.database;

import com.helper.GlobalVariables;
import com.model.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class StudentAssignmentDAOImpl {
    @Autowired
    JdbcTemplate template;

    String course= GlobalVariables.course;


    public List<Assignment> getAssignList() {
        List<Assignment> list = template.query("select * from "+course+"_assignment;", new RowMapper<Assignment>(){


            public Assignment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Assignment ob=new Assignment();
                ob.setId(resultSet.getInt("Id"));
                ob.setAssgnName(resultSet.getString("AssgnName"));
                ob.setStartDate(resultSet.getDate("StartDate"));
                ob.setEndDate(resultSet.getDate("EndDate"));
                ob.setAssgnLink(resultSet.getString("AssgnLink"));
                ob.setLateSub(resultSet.getString("LateSub"));
                return ob;
            }
        });
        return list;
    }

    public void upload(Assignment stud){

        Timestamp edate = new Timestamp(stud.getEndDate().getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Timestamp sdate = new Timestamp(new Date().getTime());

        System.out.println(edate.toString());

        String query="insert into "+course+"_assignment (AssgnName, StartDate, EndDate, LateSub, AssgnLink) values (" +
                "  '"+stud.getAssgnName()+"','"+formatter.format(sdate)+"','"+formatter.format(edate)+"'" +
                ",'"+stud.getLateSub()+"','"+stud.getAssgnLink()+"');";

        template.update(query);

    }



}



