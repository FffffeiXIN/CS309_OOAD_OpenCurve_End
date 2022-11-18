package com.sustech.service_education.service.course.impl;

import com.sustech.commonhandler.exception.InsertionFailureException;
import com.sustech.commonhandler.exception.SourceNotFoundException;
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
public class CourseServiceImp implements CourseService {

    @Autowired
    CourseMapper mapper;

    @Override
    public Result getCoursesOfTeacher(String teacher_id) {
        List<Course> courses = mapper.getCoursesOfTeacher(teacher_id);
        Map<String, Object> map = new HashMap<>();
        map.put("courses", courses);

        return Result.ok().message("获取教师课程成功").data(map);
    }

    @Override
    public Result addCourse(String course_id, String teacher_id, String course_name, String course_department, String course_type, Float credit, String status, Float fees, String info) {
        Integer department_id = mapper.getDepartmentIdByName(course_department);

        if (department_id == null){
            throw new SourceNotFoundException();
        }

        int success_course = mapper.addCourse(course_id, course_name, department_id, course_type, credit, status, fees, info);
        int success_course_teacher_relation = mapper.addCourseTeacherRelation(course_id, teacher_id);
        if(success_course == 0 || success_course_teacher_relation == 0) {
            throw new InsertionFailureException();
        } else {
            return Result.ok().message("课程添加成功").code(200);
        }
    }
}
