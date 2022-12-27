package com.sustech.service_education.service.manage.impl;

import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Student;
import com.sustech.service_education.mapper.StudentMapper;
import com.sustech.service_education.service.manage.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageServiceImpl implements ManageService {
    
    @Autowired
    StudentMapper mapper;

    @Override
    public Result blockStudent(String id) {
        Student student = mapper.selectStudentById(id);
//        student.setLocked(true);
        return Result.ok().message("锁定账户成功").code(200);
    }

    @Override
    public Result unblockStudent(String id) {
        Student student = mapper.selectStudentById(id);
//        student.setLocked(false);
        return Result.ok().message("解锁账户成功").code(200);
    }
}
