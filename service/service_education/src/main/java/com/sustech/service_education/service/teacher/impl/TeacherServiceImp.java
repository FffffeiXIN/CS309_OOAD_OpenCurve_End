package com.sustech.service_education.service.teacher.impl;

import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Teacher;
import com.sustech.service_education.mapper.TeacherMapper;
import com.sustech.service_education.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImp implements TeacherService {

    @Autowired
    TeacherMapper mapper;


    @Override
    public Result getAllTeachers() {
        List<Teacher> teachers = mapper.getAllTeachers();
        Map<String, Object> map = new HashMap<>();
        map.put("teachers", teachers);

        return Result.ok().message("获取全部教师成功").data(map);
    }

    @Override
    public Result updateInfo(String userId, String name, String department, String gender, String picture_url) {
        mapper.updateTeacher(userId,name,department,gender,picture_url);
        return Result.ok().message("老师信息更新成功").code(200);
    }
}
