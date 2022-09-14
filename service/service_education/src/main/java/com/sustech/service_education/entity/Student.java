package com.sustech.service_education.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Student implements User{
    int id;
    String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPasswd() {
        return password;
    }

    public void setPasswd(String passwd) {
        this.password = passwd;
    }
}
