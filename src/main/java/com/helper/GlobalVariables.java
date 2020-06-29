package com.helper;


import lombok.Data;

public @Data
class GlobalVariables {
    private static String course;

    public static void setCourse(String course) {
        GlobalVariables.course = course;
    }

    public static String getCourse() {
        return course;
    }
}
