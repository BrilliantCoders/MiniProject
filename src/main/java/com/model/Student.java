package com.model;

import lombok.Data;

import java.util.ArrayList;

public @Data
class Student implements Comparable<Student>{
    String regNo,name,email;
    int rollNo;
    ArrayList<String> present,absent;
    String password;


    public int compareTo(Student s) {
        if(rollNo>s.rollNo)
            return 1;
        else if(rollNo<s.rollNo)
            return -1;
        else
            return 0;
    }
}
