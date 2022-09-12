package com.sustech.service_education.controller;


import com.sustech.commonutils.Result;
import com.sustech.service_education.service.StudentEducationService;
import org.springframework.beans.factory.annotation.Autowired;
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



}
