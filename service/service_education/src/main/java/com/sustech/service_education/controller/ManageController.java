package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.service.course.CourseService;
import com.sustech.service_education.service.manage.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/education/manage")
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

    @PostMapping("/blockTeacher")
    public Result blockTeacher(String id) {
        return manageService.blockTeacher(id);
    }

    @PostMapping("/unblockTeacher")
    public Result unblockTeacher(String id) {
        return manageService.unblockTeacher(id);
    }

    @GetMapping("/getAllUnverifiedCourses")
    public Result getAllUnverifiedCourse(){
        return courseService.getAllUnverifiedCourse();
    }

    @GetMapping("/getAllExistingCourses")
    public Result getAllExistingCourses() {
        return courseService.getAllExistingCourse();
    }

    @GetMapping("/passApplication")
    public Result passApplication(String course){
        return courseService.passApplication(course);
    }

    @GetMapping("/rejectApplication")
    public Result rejectApplication(String course, String reason){
        return courseService.rejectApplication(course,reason);
    }

    @GetMapping("/getTeachersInfo")
    public Result getTeachersInfo() {
        return manageService.getTeachersInfo();
    }

    @GetMapping("/getStudentsInfo")
    public Result getStudentsInfo() {
        return manageService.getStudentsInfo();
    }
}
