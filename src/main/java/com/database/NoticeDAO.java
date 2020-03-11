package com.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class NoticeDAO {

    @Autowired
    JdbcTemplate template;

    public void insertNotice(String name,String desc){
        String query="insert into ds_mca_second_Notice ( Name, Description) values ('"+name+"','"+desc+"'); ";
        template.update(query);
    }

}
