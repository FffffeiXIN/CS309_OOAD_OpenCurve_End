package com.sustech.service_education.mapper;

import com.sustech.service_education.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
    Teacher selectTeacherByEmail(String Email);

    void insert(Teacher teacher);

    List<Teacher> getAllTeachers();

    void updateTeacher(String userId, String name, String department, String gender, String picture_url);

    void updateOnline(String id);

    void updateOffline(String id);

    void blockTeacher(String id);

    void unblockTeacher(String id);

}
