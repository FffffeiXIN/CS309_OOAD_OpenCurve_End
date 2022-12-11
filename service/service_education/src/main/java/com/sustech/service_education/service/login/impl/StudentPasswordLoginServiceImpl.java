package com.sustech.service_education.service.login.impl;

import com.sustech.commonutils.Result;
import com.sustech.commonutils.enums.Code;
import com.sustech.service_education.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentPasswordLoginServiceImpl extends AbstractStudentLogin {
    @Override
    Result doLogin(Student student, String content) {
        if(student.comparePassword(content)){
            return Result.ok().code(200).message("学生登录成功");
        }
        else return Result.error().code(Code.LOGIN_ERROR.getCode()).message("密码错误");
    }
}
