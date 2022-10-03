package com.sustech.service_education.mapper;


import com.sustech.service_education.entity.Student;
import com.sustech.service_education.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    Student selectStudentById(int id);

    void insert(Student student);

    List<Student> queryAllStudents();

    void updateStudent(Student student);

    void updateTeacher(Teacher teacher);


}
