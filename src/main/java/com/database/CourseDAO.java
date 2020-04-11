package com.database;

import com.model.Course;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    @Autowired
    JdbcTemplate template;


    public void addCourse(Course c){
        String type="";
        if(c.getType()==0){
            addCourse(c,"Class");
        }
        else if(c.getType()==1){
            addCourse(c,"Lab");
        }
        else {
            addCourse(c,"Class");
            addCourse(c,"Lab");
        }


    }

    public void addCourse(Course c,String type){
        String query="insert into courses (CourseName, SubjectName, BranchName, Semester, Year, Type) values " +
                "('"+c.getCourseName()+"','"+c.getSubName()+"','"+c.getBranchName()+"'," +
                ""+c.getSemester()+","+c.getYear()+",'"+type+"')";
        template.update(query);
    }


    public void initStudent(String tableName,ArrayList<Student> students){
        String query="CREATE TABLE "+tableName+"_student (" +
                "  RegNo VARCHAR(45) NOT NULL," +
                "  RollNo INTEGER UNSIGNED NOT NULL," +
                "  Name VARCHAR(45) NOT NULL," +
                "  Email VARCHAR(45) NOT NULL," +
                "  Password VARCHAR(45) NOT NULL," +
                "  LastVisit DATETIME NULL," +
                "  LastVisitNotice DATETIME NULL," +
                "  LastVisitMaterial DATETIME NULL" +
                "  PRIMARY KEY (`RegNo`)" +
                ")";

        template.update(query);

        for (Student st:students){
            query="insert into "+tableName+"_student values( '"+st.getRegNo()+"' , "+st.getRollNo()+" , '"+st.getName()+"'" +
                    " ,'"+st.getEmail()+"' ,'"+st.getPassword()+"');";
            template.update(query);

            query="insert into "+tableName+"_attendance values( '"+st.getRegNo()+"' , "+st.getRollNo()+" );";
            template.update(query);
        }

    }

    public void initAttendance(String tableName){
        String query="CREATE TABLE "+tableName+"_attendance (" +
                "  RegNo VARCHAR(45) NOT NULL," +
                "  RollNo INTEGER UNSIGNED NOT NULL," +
                "  PRIMARY KEY (`RegNo`)" +
                ")";


        template.update(query);
    }

    public void initNotice(String tableName){
        String query=  "CREATE TABLE  "+tableName+"_notice (" +
                "  Id int(10) unsigned NOT NULL auto_increment,\n" +
                "  Name varchar(45) NOT NULL,\n" +
                "  Description text NOT NULL,\n" +
                "  PRIMARY KEY  (Id)\n" +
                ");";
        template.update(query);

    }

    public void initTeachingmaterial(String tableName){
       String query=  "CREATE TABLE  "+tableName+"_teachingmaterial (" +
                "  Id int(10) unsigned NOT NULL auto_increment," +
                "  Name varchar(45) NOT NULL," +
                "  Description text NOT NULL," +
                "  File text NOT NULL,"+
                "  PRIMARY KEY  (Id)\n" +
                ");";
        template.update(query);

    }

    public void initAssignment(String tableName){
        String query=  "CREATE TABLE  "+tableName+"_assignment (" +
                "  Id int(10) unsigned NOT NULL auto_increment," +
                "  AssgnName varchar(45) NOT NULL," +
                "  StartDate datetime NOT NULL," +
                "  EndDate datetime NOT NULL," +
                "  LateSub varchar(45) NOT NULL," +
                "  AssgnLink text NOT NULL," +
                "  PRIMARY KEY  (Id));";
        template.update(query);

    }



    public void addCourseStudent(ArrayList<Student> students, Course c){

        String query;
        String tableName=String.valueOf(c.getSubName()+"_"+c.getCourseName()+"_"+c.getBranchName()+"_"+c.getSemester()+"_"+c.getYear());
        tableName=tableName.replaceAll(" ","");

        initAttendance(tableName);
        initStudent(tableName,students);
        initNotice(tableName);
        initAssignment(tableName);
        initTeachingmaterial(tableName);

    }



    public List<Course> showCourse(){
        String query="select * from courses";

        List<Course> list=template.query(query, new RowMapper<Course>() {
            public Course mapRow(ResultSet rr, int i) throws SQLException {
                Course c=new Course();
                // Id, , , , , ,
                c.setCourseName(rr.getString("CourseName"));
                c.setBranchName(rr.getString("BranchName"));
                c.setSemester(rr.getInt("Semester"));
                c.setSubName(rr.getString("SubjectName"));
                //c.setType(rr.getInt("Type"));
                c.setYear(rr.getInt("Year"));

                return c;
            }
        });

        return list;
    }


}
