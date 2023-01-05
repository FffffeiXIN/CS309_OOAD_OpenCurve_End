package com.sustech.service_education.service.course;

import com.sustech.commonutils.Result;

public interface CourseService {
    Result getAllCourses();

    Result getCoursesOfTeacher(String teacher_id);

    Result getCoursesOfStudent(String student_id);

    Result addCourse(String course_id, String teacher_id, String course_name, String course_department, String course_type, Float credit, String status, Float fees, String info);

    Result getAllDepartments();

    Result getAllUnverifiedCourse();

    Result getAllExistingCourse();

    Result passApplication(String course);

    Result rejectApplication(String course,String reason);

    Result enrollCourse(String student_id, String course_id);

    Result getStudentsOfCourse(String course_id);

    Result removeStudentFromCourse(String course_id, String student_id);
}
