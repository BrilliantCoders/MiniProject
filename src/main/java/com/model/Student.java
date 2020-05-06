package com.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public @Data
class Student implements Comparable<Student>{
    String regNo,name,email;
    int rollNo;
    ArrayList<String> present,absent;
    String password;

    double percent;

    // ascending
    public int compareTo(Student s) {
        if(percent>s.percent)
            return 1;
        else if(percent<s.percent)
            return -1;
        else
            return 0;
    }
}
