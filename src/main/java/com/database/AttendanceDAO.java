package com.database;

import com.model.Student;
import com.mysql.jdbc.DatabaseMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttendanceDAO {
    @Autowired
    JdbcTemplate template;
    List<Student> list=null;
    public List<Student> getStudentList(){

        if(list!=null)
            return list;

        list=new ArrayList<Student>();
        String query="select * from ds_mca_second_student;";
        list=  template.query(query, new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student ob=new Student();
                ob.setName(resultSet.getString("Name"));
                ob.setEmail(resultSet.getString("Email"));
                ob.setRegNo(resultSet.getString("RegNo"));
                ob.setRollNo(resultSet.getInt("RollNo"));
                return ob;
            }
        });

        return list;

    }

    public void createDateColumn(String date){
        // check if column exist or not
        String query="select count("+date+") as dateCount from ds_mca_second_attendance";
        Integer exist=0;

        try {
            exist=template.queryForObject(query, new RowMapper<Integer>() {
                public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                    System.out.println("count== "+resultSet.getInt("dateCount"));
                    return 1;
                }
            });
            System.out.println(exist);

        }
        catch (Exception e){

            e.printStackTrace();
        }

        if(exist==0){
            query="Alter table ds_mca_second_attendance add column "+date+" VARCHAR(45) NOT NULL DEFAULT 'P'";
            template.update(query);
        }

    }



    public void markAttendance(String date,String absentees){


        createDateColumn(date);

        String ab="";
        String[] absenteesList=absentees.split(",");
        for (String s:absenteesList) {
            ab+="'"+s+"',";
        }
        ab=ab.substring(0,ab.length()-1);



        try {
            String query="Alter table ds_mca_second_attendance drop column "+date+";";
            template.update(query);
        }
        catch (Exception e){

        }

        String query="Alter table ds_mca_second_attendance add column "+date+" VARCHAR(55) NOT NULL DEFAULT 'P'";
        template.update(query);


        query="update ds_mca_second_attendance set "+date+"='A' where RegNo in ("+ab+");";
        int y=template.update(query);
    }


    public void markAttendanceViaList(ArrayList<String> headers,ArrayList<Student> students){

        for (int i=2;i<headers.size();i++) {
            headers.set(i,headers.get(i).replaceAll("[ :]","_"));
            createDateColumn(headers.get(i));
        }

        int count=0;

        String query;
        for (Student st:students){
            query="update ds_mca_second_attendance set ";
            int i=0;
            for(String attendance:st.getPresent()){
                query=query+headers.get(i+2)+"='"+attendance+"' ,";
                i++;
            }
            query=query.substring(0,query.length()-1);
            query+="where RollNo="+st.getRollNo()+";";

            template.update(query);

            System.out.println("uploaded "+count+" student data");
        }


    }




    public List<String> getAttendanceHeader(){


        String query="SHOW columns FROM ds_mca_second_attendance";
        List<String> list=template.query(query, new RowMapper<String>() {
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("Field");
            }
        });
        System.out.println(list);
        return list;
    }



    public List<Student> getAttendance(){


        String query="select * FROM ds_mca_second_attendance order by RollNo asc";
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


}
