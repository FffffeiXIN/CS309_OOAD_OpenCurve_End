package com.sustech.service_education.service.course.impl;

import com.sustech.commonhandler.exception.DatabaseOperationFailureException;
import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Course;
import com.sustech.service_education.mapper.CourseMapper;
import com.sustech.service_education.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper mapper;

    @Override
    public Result getAllCourses() {
        List<Course> courses = mapper.getAllCourses();
        Map<String, Object> map = new HashMap<>();
        map.put("courses", courses);

        return Result.ok().message("获取全部课程成功").data(map);
    }

    @Override
    public Result getCoursesOfTeacher(String teacher_id) {
        List<Course> courses = mapper.getCoursesOfTeacher(teacher_id);
        Map<String, Object> map = new HashMap<>();
        map.put("courses", courses);

        return Result.ok().message("获取教师课程成功").data(map);
    }

    @Override
    public Result getCoursesOfStudent(String student_id) {
        List<Course> courses = mapper.getCoursesOfStudent(student_id);
        Map<String, Object> map = new HashMap<>();
        map.put("courses", courses);

        return Result.ok().message("获取学生课程成功").data(map);
    }

    @Override
    public Result addCourse(String course_id, String teacher_id, String course_name, String department, String course_type, Float credit, String status, Float fee, String info) {

        int success_course = mapper.addCourse(course_id, course_name, department, course_type, credit, status, fee, info);
        int success_course_teacher_relation = mapper.addCourseTeacherRelation(course_id, teacher_id);
        if(success_course == 0 || success_course_teacher_relation == 0) {
            throw new DatabaseOperationFailureException();
        } else {
            return Result.ok().message("课程添加成功").code(200);
        }
    }

    @Override
    public Result getAllDepartments() {
        List<String> departments = mapper.getAllDepartments();
        Map<String, Object> map = new HashMap<>();
        map.put("departments", departments);

        return Result.ok().message("获取院系成功").data(map);
    }

    @Override
    public Result getAllUnverifyCourse() {
        List<Course> res = mapper.getAllUnverifyCourses();
        Map<String, Object> map = new HashMap<>();
        map.put("unverify_course",res);
        return Result.ok().code(200).message("获取未审核课程成功").data(map);
    }

    @Override
    public Result passApplication(String course) {
        mapper.passCourse(course);
        return Result.ok().code(200).message("课程通过成功");
    }

    @Override
    public Result rejectApplication(String course, String reason) {
        mapper.rejectCourse(course,reason);
        return Result.ok().code(200).message("课程审核不通过成功");
    }
}
