package com.model;

import lombok.Data;

import java.util.ArrayList;


public @Data
class LabMarks {
    String name;
    int rollNo;
    ArrayList<Double> executionMarks;
}
