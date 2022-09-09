package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Teacher;
import com.sustech.service_education.service.TeacherEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherEducationController {

    @Autowired
    private TeacherEducationService teacherService;

    @GetMapping("list")
    public Result queryAllTeacher(){
        List<Teacher> teachers=teacherService.queryAll();
        return Result.ok().addData("teachers",teachers).message("包含所有的老师对象信息");
    }


}
