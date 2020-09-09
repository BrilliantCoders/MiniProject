package com.model;

import lombok.Data;

import java.util.Date;

public @Data
class TeachingMaterial {

    int id;
    String Name,Description;
    String file;
    Date date;
}
