package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/education/course")
public class CourseController{

    @Autowired
    CourseService courseService;

    @GetMapping("/getCoursesOfTeacher")
    public Result getCoursesOfTeacher(String teacher_id) {
        return courseService.getCoursesOfTeacher(teacher_id);
    }

    @PostMapping("/addCourse")
    public Result addCourse(String course_id, String course_teacher, String course_name, String course_department, String course_type, Float course_credit, String course_status, Float course_fees, String course_info) {
        return courseService.addCourse(course_id, course_teacher, course_name, course_department, course_type, course_credit, course_status, course_fees, course_info);
    }
}
