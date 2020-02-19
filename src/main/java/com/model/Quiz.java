package com.model;

import lombok.Data;

import java.util.Date;

public@Data
class Quiz {

    int id, duration;
    String quizName, course;
    Date startDateTime, endDateTime;
    int active=0;
}
