package com.sustech.service_education.service.course;

import com.sustech.commonutils.Result;

public interface CourseService {
    Result getCoursesOfTeacher(String teacher_id);

    Result addCourse(String course_id, String teacher_id, String course_name, String course_department, String course_type, Float credit, String status, Float fees, String info);
}
