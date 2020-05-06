package com.database;

import com.model.TeachingMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ViewTeachingMaterialDAO {
    @Autowired
    JdbcTemplate template;



    public List<TeachingMaterial> getMaterialList() {
        List<TeachingMaterial> list = template.query("select * from ds_mca_second_teachingmaterial;", new RowMapper<TeachingMaterial>(){


            public TeachingMaterial mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                TeachingMaterial ob=new TeachingMaterial();
                ob.setId(resultSet.getInt("Id"));
                ob.setName(resultSet.getString("Name"));
                ob.setDescription(resultSet.getString("Description"));
                ob.setFile(resultSet.getString("File"));
                return ob;
            }
        });
        return list;
    }
}