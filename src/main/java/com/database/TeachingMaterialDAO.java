package com.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TeachingMaterialDAO {

    @Autowired
    JdbcTemplate template;

    public void insertMaterial(String name,String desc,String fileName){
        String query="insert into ds_mca_second_teachingMaterial ( Name, Description, File) values ('"+name+"','"+desc+"','"+fileName+"'); ";
        template.update(query);
    }

}
