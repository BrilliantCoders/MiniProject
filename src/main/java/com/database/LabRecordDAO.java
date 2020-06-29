package com.database;

import com.helper.GlobalVariables;
import com.model.LabMarks;
import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LabRecordDAO {

    @Autowired
    JdbcTemplate template;
    


    public void createDateColumn(String date){
        System.out.println("date "+date);
        try {
            String query="Alter table "+GlobalVariables.getCourse()+"_labrecord drop column "+date+";";
            template.update(query);
        }
        catch (Exception e){

        }

        String query="Alter table "+GlobalVariables.getCourse()+"_labrecord add column "+date+" DOUBLE NOT NULL DEFAULT 0.0";
        template.update(query);

    }



    public void uploadMarksViaList(ArrayList<String> headers, ArrayList<LabMarks> list){

        for (int i=2;i<headers.size();i++) {
            headers.set(i,headers.get(i).replaceAll("[ :]","_"));
            System.out.println(headers.get(i));
            createDateColumn(headers.get(i));
        }

        int count=0;

        String query;
        for (LabMarks marks:list){
            query="update "+GlobalVariables.getCourse()+"_labrecord set ";
            int i=0;
            for(Double mark:marks.getExecutionMarks()){
                query=query+headers.get(i+2)+"="+mark+" ,";
                i++;
            }
            query=query.substring(0,query.length()-1);
            query+="where RollNo="+marks.getRollNo()+";";

            template.update(query);

            System.out.println("uploaded "+count+" student data");
        }


    }
}
