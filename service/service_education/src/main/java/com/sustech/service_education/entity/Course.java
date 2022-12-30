package com.sustech.service_education.entity;

import lombok.Data;

@Data
public class Course {

    String id;

    String name;

    Float credit;

    String department;

    String info;

    String course_type;

    String status;

    Double fee;

    String others;
}
