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

    @GetMapping("/getAllCourses")
    public Result getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/getCoursesOfTeacher")
    public Result getCoursesOfTeacher(String teacher_id) {
        return courseService.getCoursesOfTeacher(teacher_id);
    }

    @PostMapping("/addCourse")
    public Result addCourse(String course_id, String course_teacher, String course_name, String course_department, String course_type, Float course_credit, String course_status, Float course_fee, String course_info) {
        return courseService.addCourse(course_id, course_teacher, course_name, course_department, course_type, course_credit, course_status, course_fee, course_info);
    }

    @GetMapping("/getCoursesOfStudent")
    public Result getCoursesOfStudent(String student_id) {
        return courseService.getCoursesOfStudent(student_id);
    }

    @GetMapping("/getAllDepartments")
    public Result getAllDepartments() {
        return courseService.getAllDepartments();
    }

    @PostMapping("/enrollCourse")
    public Result enrollCourse(String student_id, String course_id) {
        return courseService.enrollCourse(student_id, course_id);
    }

    @GetMapping("/getStudentsOfCourse")
    public Result getStudentsOfCourse(String course_id) {
        return courseService.getStudentsOfCourse(course_id);
    }

    @PostMapping("/removeStudentFromCourse")
    public Result removeStudentFromCourse(String course_id, String student_id) {
        return courseService.removeStudentFromCourse(course_id, student_id);
    }
}
