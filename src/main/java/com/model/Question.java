package com.model;

import lombok.Data;

public @Data
class Question {
    int id;
    String question,option1,option2,option3,option4,expanation;
    int answer;
}
