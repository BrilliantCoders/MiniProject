package com.database;

import com.helper.GlobalVariables;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerformanceDAO {

    @Autowired
    JdbcTemplate template;

    public List<String> getAttendanceHeader(){

        String query="SHOW columns FROM "+ GlobalVariables.getCourse()+"_attendance";
        List<String> list=template.query(query, new RowMapper<String>() {
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("Field");
            }
        });
        System.out.println(list);
        return list;
    }

    public Student getStudentDetail(){

        String query="select * FROM "+ GlobalVariables.getCourse()+"_student where RegNo='"+GlobalVariables.getRegNo()+"'";
        final Student student=template.queryForObject(query, new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student ob=new Student();
                ob.setRegNo(resultSet.getString("RegNo"));
                ob.setRollNo(resultSet.getInt("RollNo"));
                ob.setEmail(resultSet.getString("Email"));
                ob.setName(resultSet.getString("Name"));
                ob.setLatVisit(resultSet.getTimestamp("LastVisit"));

                return ob;
            }
        });

        return student;
    }



    public List<Student> getAttendance(){

        System.out.println(GlobalVariables.getCourse());
        String query="select * FROM "+GlobalVariables.getCourse()+"_attendance where RegNo='"+GlobalVariables.getRegNo()+"'";
        List<Student> list=template.query(query, new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student s=new Student();

                s.setRegNo(resultSet.getString(1));
                s.setRollNo(resultSet.getInt(2));
                int j=3;
                String ab="";
                ArrayList<String> present=new ArrayList<String>();
                int pre=0,abs=0;
                try {
                    while ((ab=resultSet.getString(j))!=null){
                        present.add(ab);
                        if(ab.equalsIgnoreCase("P"))
                            pre++;
                        else
                            abs++;
                        j++;
                    }
                }
                catch (Exception e){

                }

                if(pre==0 && abs==0){
                    s.setPercent(100);
                }
                else{
                    s.setPercent(((pre*1.0)/(pre+abs))*100);
                }

                s.setPresent(present);
                return s;
            }
        });
        System.out.println(list);
        return list;
    }

    public List<Integer> getQuizResult(){
        System.out.println(GlobalVariables.getCourse());
        String query="select * FROM "+GlobalVariables.getCourse()+"_quizresult  where RegNo='"+GlobalVariables.getRegNo()+"'";
        List<Integer> list=template.queryForObject(query, new RowMapper<List<Integer>>() {
            public List<Integer> mapRow(ResultSet resultSet, int i) throws SQLException {
                List<Integer> list=new ArrayList<Integer>();
                int j=2;
                Integer marks;
                try {
                    System.out.println("here");
                    while ((marks=(int) Math.ceil(resultSet.getDouble(j)))!=null){
                        list.add(marks);
                        j++;
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                return list;
            }
        });
        System.out.println(list);
        return list;
    }


}
