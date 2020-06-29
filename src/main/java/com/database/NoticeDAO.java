package com.database;

import com.helper.GlobalVariables;
import com.model.Notice;
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

public class NoticeDAO {

    @Autowired
    JdbcTemplate template;

    

    public void insertNotice(String name,String desc){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp sdate = new Timestamp(new Date().getTime());
        String query="insert into "+GlobalVariables.getCourse()+"_Notice ( Name, Description,Date) values ('"+name+"','"+desc+"','"+
                formatter.format(sdate)+"'); ";
        template.update(query);
    }

    public List<Notice> showNotice(){

        String query="select * from "+GlobalVariables.getCourse()+"_Notice order by id desc";
        List<Notice> list=template.query(query, new RowMapper<Notice>() {
            public Notice mapRow(ResultSet resultSet, int i) throws SQLException {
                Notice n=new Notice();
                n.setId(resultSet.getInt("Id"));
                n.setName(resultSet.getString("Name"));
                n.setDescription(resultSet.getString("Description"));
                n.setDate(resultSet.getTimestamp("Date"));
                return n;
            }
        });
        return list;
    }

    public void remove(int id){
        String query="delete from "+GlobalVariables.getCourse()+"_Notice where id="+id;
        template.update(query);
    }


    public Timestamp getNoticeUploadDate(int id){
        String query="select Date from "+GlobalVariables.getCourse()+"_Notice where id="+id;
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

        String query="select RollNo,Name from databasemanagementsystem_btech_cs_3_2020_student where LastVisitNotice <= '"+formatter.format(d)+"' order by RollNo asc;";
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
