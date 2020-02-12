package com.database;

import com.model.AdminDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLoginDAO {
    @Autowired
    JdbcTemplate template;

    public boolean authenticate(String userName,String password){
        String query="select * from admin_login where AdminName='"+userName+"' and Password='"+password+"'; ";
        System.out.println(query);
        //String q="insert into admin_login(AdminName,Password) values ('rajat','1234');";
        //template.update(q);
        AdminDetail admin=null;

        try {

            admin= template.queryForObject(query, new RowMapper<AdminDetail>() {

                public AdminDetail mapRow(ResultSet resultSet, int i) throws SQLException {

                    AdminDetail ob=new AdminDetail();

                    return ob;

                }

            });
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Not Authenticated");
        }




        if(admin==null){
            return false;
        }
        else{
           return true;
        }


    }


}
