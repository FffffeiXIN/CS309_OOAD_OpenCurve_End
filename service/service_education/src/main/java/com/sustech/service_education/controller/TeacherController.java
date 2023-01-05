package com.sustech.service_education.controller;


import com.sustech.commonutils.Result;
import com.sustech.service_education.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/update")
    public Result updateInfo(String userId, String name,String department, String gender,String picture_url){
        return teacherService.updateInfo(userId,name,department,gender,picture_url);
    }
}
