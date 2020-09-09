package com.helper;


import lombok.Data;

public @Data
class GlobalVariables {
    private static String course;
    private static String regNo;

    public static void setCourse(String course) {
        GlobalVariables.course = course;
    }

    public static String getCourse() {
        return course;
    }

    public static void setRegNo(String regNo) {
        GlobalVariables.regNo = regNo;
    }

    public static String getRegNo() {
        return regNo;
    }
}
