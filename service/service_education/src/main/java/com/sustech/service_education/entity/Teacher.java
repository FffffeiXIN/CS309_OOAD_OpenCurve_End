package com.sustech.service_education.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Teacher{
    Integer id;
    String name;
    String department;
    Integer password;
    Integer failTime =0;
}
