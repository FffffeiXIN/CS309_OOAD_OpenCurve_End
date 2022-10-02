package com.sustech.service_education.service.login.impl;

import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Student;
import com.sustech.service_education.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentPasswordLoginService extends AbstractStudentLogin {
    @Override
    Result doLogin(Student student, String content) {
        if(student.getPassword().equals(content)) return Result.ok();
        else return Result.error();
    }
}
