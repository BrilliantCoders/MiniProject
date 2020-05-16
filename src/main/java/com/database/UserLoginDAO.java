package com.database;

import com.helper.GlobalVariables;
import com.model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginDAO {
    @Autowired
    JdbcTemplate template;

    String course= GlobalVariables.course;

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

}
