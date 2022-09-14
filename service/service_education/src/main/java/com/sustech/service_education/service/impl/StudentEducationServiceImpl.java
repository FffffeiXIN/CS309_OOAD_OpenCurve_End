package com.sustech.service_education.service.impl;

import com.sustech.service_education.entity.Student;
import com.sustech.service_education.service.StudentEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sustech.service_education.mapper.StudentMapper;



@Service
public class StudentEducationServiceImpl implements StudentEducationService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public boolean chooseCourse(int id) {
        return false;
    }

    @Override
    //可以区分下密码错误和没有此用户
    public boolean checkStudent(int id, String passwd) {
        Student res = studentMapper.select(id);
        if(res.getPasswd().equals(passwd)) return true;
        return false;
    }
}
