package com.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;

public class EditRemoveDAO {

    @Autowired
    JdbcTemplate template;
    String tableName="";



    public void remove(String table,int id){
        String query="delete from "+tableName+"_"+table+" where id="+id;
        template.update(query);
    }

    public void edit(int id, HashMap<String,String> mp){

    }

}
