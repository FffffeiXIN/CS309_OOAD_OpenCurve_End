package com.sustech.service_education.entity;

import lombok.Data;

@Data
public class Assignment {
    int id;
    String title;
    String course_id;
    String teacher_id;
    String due_date;
    int resubmission_allowed;
    String accept_resubmission_until;
    String requirements;
    String attachment;
}
