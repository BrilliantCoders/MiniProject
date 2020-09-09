package com.database;

import com.helper.GlobalVariables;
import com.helper.MailHelper;
import com.model.TeachingMaterial;
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

public class TeachingMaterialDAO {

    @Autowired
    JdbcTemplate template;

    @Autowired
    MailHelper helper;

   
    public void insertMaterial(String name,String desc,String fileName){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp sdate = new Timestamp(new Date().getTime());

        String query="insert into "+GlobalVariables.getCourse()+"_teachingMaterial ( Name, Description, File , Date) values ('"+name+"','"+desc+"','"+fileName+"','"+
                formatter.format(sdate)+"'); ";
        template.update(query);
       // helper.send("New Teaching Material Added","Material - "+name);
    }


    public List<TeachingMaterial> showMaterial(){

        String query="select * from "+GlobalVariables.getCourse()+"_teachingmaterial";
        List<TeachingMaterial> list=template.query(query, new RowMapper<TeachingMaterial>() {
            public TeachingMaterial mapRow(ResultSet resultSet, int i) throws SQLException {
                TeachingMaterial n=new TeachingMaterial();
                n.setId(resultSet.getInt("Id"));
                n.setName(resultSet.getString("Name"));
                n.setDescription(resultSet.getString("Description"));
                n.setDate(resultSet.getTimestamp("Date"));
                n.setFile(resultSet.getString("File"));
                return n;
            }
        });
        return list;
    }

    public void remove(int id){
        String query="delete from "+GlobalVariables.getCourse()+"_teachingmaterial where id="+id;
        template.update(query);
    }


    public Timestamp getTeachingMaterialUploadDate(int id){
        String query="select Date from "+GlobalVariables.getCourse()+"_teachingmaterial where id="+id;
        Timestamp d=template.queryForObject(query, new RowMapper<Timestamp>() {
            public Timestamp mapRow(ResultSet resultSet, int i) throws SQLException {
                Timestamp d=resultSet.getTimestamp("Date");
                return d;
            }
        });

        return d;
    }

    public List<Student> getStudentList(Timestamp d){

        List<Student> list;
        list=new ArrayList<Student>();
        System.out.println(d.toString());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(d));

        String query="select RollNo,Name from "+GlobalVariables.getCourse()+"_student where LastVisitMaterial <= '"+formatter.format(d)+"' or LastVisitMaterial is null order by RollNo asc;";
        list=  template.query(query, new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student ob=new Student();
                ob.setName(resultSet.getString("Name"));
                ob.setRollNo(resultSet.getInt("RollNo"));
                return ob;
            }
        });

        return list;

    }



}
