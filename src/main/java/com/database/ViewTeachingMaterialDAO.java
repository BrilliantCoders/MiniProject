package com.database;

import com.helper.GlobalVariables;
import com.model.TeachingMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ViewTeachingMaterialDAO {
    @Autowired
    JdbcTemplate template;

    
    public List<TeachingMaterial> getMaterialList() {
        List<TeachingMaterial> list = template.query("select * from "+GlobalVariables.getCourse()+"_teachingmaterial;", new RowMapper<TeachingMaterial>(){
            public TeachingMaterial mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                TeachingMaterial ob=new TeachingMaterial();
                ob.setId(resultSet.getInt("Id"));
                ob.setName(resultSet.getString("Name"));
                ob.setDescription(resultSet.getString("Description"));

                ob.setDate(resultSet.getTimestamp("Date"));
                ob.setFile(resultSet.getString("File"));
                return ob;
            }
        });
        System.out.println(list.size());
        return list;
    }

    public void updateLastVisit(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp sdate = new Timestamp(new Date().getTime());

        String query="update "+GlobalVariables.getCourse()+"_Student set LastVisit='" +
                formatter.format(sdate)+"' , LastVisitMaterial= '"+formatter.format(sdate)+"' where RegNo='"+GlobalVariables.getRegNo()+"'";
        template.update(query);
    }
}
