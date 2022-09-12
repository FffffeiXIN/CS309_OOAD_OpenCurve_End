package com.sustech.service_education.controller;


import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.User;
import com.sustech.service_education.service.StudentEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentEducationController extends BaseEducationController {


    @Autowired
    private StudentEducationService studentService;

    public Result chooseCourse(){
        return Result.error();
    }

    public Result login(int id,String passwd){
        return Result.error();
    }

    public Result register(User user){
        return Result.error();
    }



}
