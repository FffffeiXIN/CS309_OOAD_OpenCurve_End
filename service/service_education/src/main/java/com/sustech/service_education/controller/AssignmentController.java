package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.service.assignment.AssignmentService;
import com.sustech.service_education.service.course.CourseService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/education/assignment")
@Api(tags = "接口测试")
public class AssignmentController {
    @Autowired
    AssignmentService service;
    @Autowired
    CourseService courseService;

    @PostMapping("/release")
    public Result addAssignment(String title, String course_id, String teacher_id, String due_date, int resubmission_allowed, String accept_resubmission_until, String requirements,String attachment) {
        return service.addAssignment(title, course_id, teacher_id, due_date, resubmission_allowed, accept_resubmission_until, requirements,attachment);
    }

    @GetMapping("/getStudentAssignments")
    public Result getStudentAssignment(String student_id) {
        Result result = courseService.getCoursesOfStudent(student_id);
        result.getData().put("assignments",service.getStudentAssignment(student_id));
        return result;
    }

    @GetMapping("/getTeacherAssignments")
    public Result getTeacherAssignment(String teacher_id) {
        Result result = courseService.getCoursesOfTeacher(teacher_id);
        result.getData().put("assignments",service.getTeacherAssignment(teacher_id));
        return result;
    }

    @PostMapping("/submit")
    public Result submit(int assignment_id, String student_id, List<String> content_url, String text) {
        return service.submitAssignment(assignment_id, student_id, text, content_url);
    }

    @GetMapping("/getSubmissionOfStudent")
    public Result getSubmissionByStudent(int assignment_id, String student_id) {
        return service.getSubmission(assignment_id, student_id);
    }

    @PostMapping("/gradeSubmission")
    public Result gradeSubmission(int assignment_id, String student_id, double score) {
        return service.updateScore(assignment_id,student_id,score);
    }

    @GetMapping("/getAssignmentById")
    public Result getAssignmentById(int assignment_id) {
        return service.getAssignmentById(assignment_id);
    }

    @GetMapping("/getSubmissionsOfAssignment")
    public Result getSubmissionsOfAssignment(int assignment_id) {
        return service.getSubmissionsOfAssignment(assignment_id);
    }

    @PostMapping("/updateAssignment")
    public Result updateAssignment(int assignment_id, String title, String course_id, String teacher_id, String due_date, int resubmission_allowed, String accept_resubmission_until, String requirements,String attachment) {
        // update by assignment_id
        return service.updateAssignment(assignment_id,title,course_id,teacher_id,due_date,resubmission_allowed,accept_resubmission_until,requirements,attachment);
    }

}
