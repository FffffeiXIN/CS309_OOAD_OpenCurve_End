package com.sustech.service_education.mapper;
import com.sustech.service_education.entity.Teacher;

import java.util.List;

public interface TeacherMapper {
    Teacher selectTeacherById(int id);

    void insert(Teacher teacher);

    List<Teacher> queryAllTeachers();

    void updateTeacher(Teacher teacher);
}
