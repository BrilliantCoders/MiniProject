package com.database;

import com.helper.GlobalVariables;
import com.model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserLoginDAO {
    @Autowired
    JdbcTemplate template;



    public boolean authenticate(String userID,String userPassword) {
        String query="select * from user_Login  where UserName='"+userID+"' and Password='"+userPassword+"'; ";
        System.out.println(query);
        UserDetail user=null;

        try {

            user= template.queryForObject(query, new RowMapper<UserDetail>() {

                public UserDetail mapRow(ResultSet resultSet, int i) throws SQLException {

                    UserDetail ob=new UserDetail();

                    return ob;

                }

            });
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Not Authenticated");
        }

        if(user==null){
            return false;
        }
        else{
            return true;
        }
    }


    public List<String> getAllCourses() {
        String query = "select * from courses";

        List<String> list = template.query(query, new RowMapper<String>() {
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                String s="";
                //Id, CourseName, SubjectName, BranchName, Semester, Year, Type
                s+=resultSet.getString("SubjectName");
                s+="_";
                s+=resultSet.getString("CourseName");
                s+="_";
                s+=resultSet.getString("BranchName");
                s+="_";
                s+=resultSet.getString("Semester");
                s+="_";
                s+=resultSet.getString("Year");
                s+="_";
                s+=resultSet.getString("Type");
                s=s.replaceAll(" ","");
                return s;
            }
        });

        return list;
    }

}
