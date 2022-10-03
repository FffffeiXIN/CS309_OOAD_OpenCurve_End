package com.sustech.service_education.entity;

import lombok.Data;

@Data
public abstract class AbstractUser{
    private Integer id = null;
    private String name = null;
    private String passwd = null;
    private Integer failTime =0;
    public void fail(){
        failTime++;
    }

}
