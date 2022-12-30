package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.service.assignment.AssignmentService;
import com.sustech.service_education.service.course.CourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("assignment")
@Api(tags = "接口测试")
public class AssignmentController {
    @Autowired
    AssignmentService service;
    @Autowired
    CourseService courseService;

    @PostMapping("/release")
    public Result addAssignment(int assignment_id, String title, String course_id, String teacher_id, String due_date, int resubmission_allowed, String accept_resubmission_until, String requirements,String attachment) {
        return service.addAssignment(assignment_id, title, course_id, teacher_id, due_date, resubmission_allowed, accept_resubmission_until, requirements,attachment);
    }

    @GetMapping("/getStudentAssignments")
    public Result getStudentAssignment(String student_id) {
        // first get the courses of student
        // add the courses to the return result
        // then get the assignment and add assignments to the return result
        Result result = courseService.getCoursesOfStudent(student_id);
        result.getData().put("assignments",service.getStudentAssignment(student_id));
        return result;
    }

    @GetMapping("/getTeacherAssignments")
    public Result getTeacherAssignment(String teacher_id) {
        // first get the courses of teacher
        // add the courses to the return result
        // then get the assignment and add assignments to the return result
        Result result = courseService.getCoursesOfTeacher(teacher_id);
        result.getData().put("assignments",service.getTeacherAssignment(teacher_id));
        return result;
    }

    @PostMapping("/submit")
    public Result submit(int assignment_id, String student_id, List<String> content_url, String text) {
        return service.submitAssignment(assignment_id, student_id, text, content_url);
    }

    @GetMapping("/getSubmission")
    public Result getSubmissionByStudent(int assignment_id, String student_id) {
        return service.getSubmission(assignment_id, student_id);
    }

    @PostMapping("/gradeSubmission")
    public Result gradeSubmission(int assignment_id, String student_id, double score) {
        return service.updateScore(assignment_id,student_id,score);
    }


}
