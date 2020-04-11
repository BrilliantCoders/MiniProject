package com.model;

import lombok.Data;

import java.util.Date;

public @Data
class Notice {
    int id;
    String Name,Description;
    Date date;
}
