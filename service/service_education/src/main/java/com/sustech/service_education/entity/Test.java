package com.sustech.service_education.entity;

import lombok.Data;

@Data
public class Test {
    Integer id;
    Integer session_id;
    String question_type;
    String title;
    String choices;
    String correct_answer;
}
