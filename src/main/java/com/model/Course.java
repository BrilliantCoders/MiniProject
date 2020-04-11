package com.model;

import lombok.Data;

public @Data
class Course {
    String subName,courseName,branchName;
    int year,semester;
    int type;
}
