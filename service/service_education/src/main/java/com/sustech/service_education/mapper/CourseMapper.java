package com.sustech.service_education.mapper;

import com.sustech.service_education.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> getCoursesOfTeacher(String teacher_id);

    int addCourse(String course_id, String course_name, Integer department_id, String course_type, Float credit, String status, Float fees, String info);

    int addCourseTeacherRelation(String course_id, String teacher_id);

    Integer getDepartmentIdByName(String department_name);
}
