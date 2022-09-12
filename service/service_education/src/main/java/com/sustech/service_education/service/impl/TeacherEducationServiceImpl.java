package com.sustech.service_education.service.impl;

import com.sustech.service_education.entity.Teacher;
import com.sustech.service_education.entity.User;
import com.sustech.service_education.mapper.TeacherMapper;
import com.sustech.service_education.service.TeacherEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherEducationServiceImpl implements TeacherEducationService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public boolean delete(Teacher teacher) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean add(Teacher teacher) {
        return false;
    }

    @Override
    public List<Teacher> queryAll() {
        return teacherMapper.queryAll();
    }

    @Override
    public boolean register(User user) {
        return false;
    }
}
