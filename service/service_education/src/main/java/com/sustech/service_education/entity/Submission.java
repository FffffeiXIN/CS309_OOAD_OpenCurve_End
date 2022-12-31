package com.sustech.service_education.entity;

import lombok.Data;

@Data
public class Submission {
    int assignment_id;
    String student_id;
    String content_url;
    String text;
    Double score;
    String submission_date;
}
