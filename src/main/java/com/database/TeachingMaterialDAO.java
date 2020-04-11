package com.database;

import com.helper.MailHelper;
import com.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TeachingMaterialDAO {

    @Autowired
    JdbcTemplate template;

    @Autowired
    MailHelper helper;

    public void insertMaterial(String name,String desc,String fileName){
        String query="insert into ds_mca_second_teachingMaterial ( Name, Description, File) values ('"+name+"','"+desc+"','"+fileName+"'); ";
        template.update(query);
        helper.send("New Teaching Material Added","Material - "+name);
    }


    public List<Notice> showNotice(){

        String query="select * from ds_mca_second_teachingmaterial";
        List<Notice> list=template.query(query, new RowMapper<Notice>() {
            public Notice mapRow(ResultSet resultSet, int i) throws SQLException {
                Notice n=new Notice();
                n.setId(resultSet.getInt("Id"));
                n.setName(resultSet.getString("Name"));
                n.setDescription(resultSet.getString("Description"));
                return n;
            }
        });
        return list;
    }

    public void remove(int id){
        String query="delete from ds_mca_second_teachingmaterial where id="+id;
        template.update(query);
    }

}
