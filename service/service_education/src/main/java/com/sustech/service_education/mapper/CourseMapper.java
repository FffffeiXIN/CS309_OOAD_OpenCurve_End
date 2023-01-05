package com.sustech.service_education.mapper;

import com.sustech.service_education.entity.Course;
import com.sustech.service_education.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

    List<Course> getAllCourses();

    List<Course> getAllUnverifiedCourses();

    List<Course> getAllExistingCourses();

    void passCourse(String course);
    void rejectCourse(String course, String reason);

    List<Course> getCoursesOfTeacher(String teacher_id);

    List<Course> getCoursesOfStudent(String student_id);

    int addCourse(String course_id, String course_name, String department, String course_type, Float credit, String status, Float fee, String info);

    int addCourseTeacherRelation(String course_id, String teacher_id);

    List<String> getAllDepartments();

    Integer getDepartmentIdByName(String department_name);

    List<Student> getStudentsByCourse(String course_id);

    Course getFeeByCourse(String course_id);

    int addCourseStudentRelation(String course_id, String student_id);

    int removeStudentFromCourse(String course_id, String student_id);
}
