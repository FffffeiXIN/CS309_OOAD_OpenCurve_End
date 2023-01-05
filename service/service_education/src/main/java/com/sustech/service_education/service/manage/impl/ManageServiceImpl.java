package com.sustech.service_education.service.manage.impl;

import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Student;
import com.sustech.service_education.entity.Teacher;
import com.sustech.service_education.mapper.StudentMapper;
import com.sustech.service_education.mapper.TeacherMapper;
import com.sustech.service_education.service.manage.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Result blockStudent(String id) {
        studentMapper.blockStudent(id);
        return Result.ok().message("锁定账户成功").code(200);
    }

    @Override
    public Result unblockStudent(String id) {
        studentMapper.unblockStudent(id);
        return Result.ok().message("解锁账户成功").code(200);
    }

    @Override
    public Result blockTeacher(String id) {
        teacherMapper.blockTeacher(id);
        return Result.ok().message("锁定账户成功").code(200);
    }

    @Override
    public Result unblockTeacher(String id) {
        teacherMapper.unblockTeacher(id);
        return Result.ok().message("解锁账户成功").code(200);
    }

    @Override
    public Result getTeachersInfo() {
        List<Teacher> teachers = teacherMapper.getAllTeachers();
        Map<String, Object> map = new HashMap<>();
        map.put("teachers", teachers);

        return Result.ok().code(200).message("获取所有老师信息成功").data(map);
    }

    @Override
    public Result getStudentsInfo() {
        List<Student> students = studentMapper.queryAllStudents();
        Map<String, Object> map = new HashMap<>();
        map.put("students", students);

        return Result.ok().code(200).message("获取所有学生信息成功").data(map);
    }
}
