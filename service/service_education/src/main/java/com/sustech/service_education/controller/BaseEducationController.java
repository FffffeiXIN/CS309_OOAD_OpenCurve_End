package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.User;

public class BaseEducationController {

    public Result login(User user){
        return Result.error();
    }

    public Result register(int id,String passwd){
        return Result.error();
    }

    public Result queryAllCourse(){
        return Result.error();
    }

    public Result queryAllTeacher(){
        return Result.error();
    }


}
