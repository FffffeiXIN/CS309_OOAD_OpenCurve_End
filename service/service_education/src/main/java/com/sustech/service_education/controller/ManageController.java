package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.service.course.CourseService;
import com.sustech.service_education.service.manage.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/manage")
public class ManageController {
    @Autowired
    ManageService manageService;
    @Autowired
    CourseService courseService;
    
    @PostMapping("/blockStudent")
    public Result blockStudent(String id) {
        return manageService.blockStudent(id);
    }

    @PostMapping("/unblockStudent")
    public Result unblockStudent(String id) {
        return manageService.unblockStudent(id);
    }

    @GetMapping("/getAllUnverifyCourse")
    public Result getAllUnverifyCourse(){
        return courseService.getAllUnverifyCourse();
    }

    @GetMapping("/passApplication")
    public Result passApplication(String course){
        return courseService.passApplication(course);
    }
    @GetMapping("/rejectApplication")
    public Result rejectApplication(String course, String reason){
        return courseService.rejectApplication(course,reason);
    }
}
