package com.model;

import lombok.Data;

import java.util.Date;

public @Data
class Assignment {
    String assgnName;
    int id;

    Date startDate,endDate;
    String lateSub,assgnLink;
}
