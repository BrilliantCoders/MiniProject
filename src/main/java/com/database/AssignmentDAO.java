package com.database;

import com.model.Assignment;
import com.model.Notice;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssignmentDAO {
    @Autowired
    JdbcTemplate template;

    public void upload(Assignment asgn){

        Timestamp edate = new Timestamp(asgn.getEndDate().getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Timestamp sdate = new Timestamp(new Date().getTime());

        System.out.println(edate.toString());

        String query="insert into ds_mca_second_assignment (AssgnName, StartDate, EndDate, LateSub, AssgnLink) values (" +
                "  '"+asgn.getAssgnName()+"','"+formatter.format(sdate)+"','"+formatter.format(edate)+"'" +
                ",'"+asgn.getLateSub()+"','"+asgn.getAssgnLink()+"');";

        template.update(query);

    }



    public void remove(int id){
        String query="delete from ds_mca_second_Assignment where id="+id;
        template.update(query);
    }





    public List<Assignment> getAssignmentList(){
        List<Assignment> list=null;
        if(list!=null)
            return list;

        list=new ArrayList<Assignment>();
        String query="select * from ds_mca_second_assignment;";
        list=  template.query(query, new RowMapper<Assignment>() {
            public Assignment mapRow(ResultSet resultSet, int i) throws SQLException {
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

}
