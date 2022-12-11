package com.sustech.service_education.controller;


import com.sustech.commonutils.Result;
import com.sustech.service_education.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/education/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/getAllTeachers")
    public Result getAllTeachers() {
        return teacherService.getAllTeachers();
    }
}
