package com.sustech.service_education.service.login.impl;

import com.sustech.commonutils.Result;
import com.sustech.commonutils.enums.Code;
import com.sustech.service_education.entity.Student;
import com.sustech.service_education.mapper.StudentMapper;
import com.sustech.service_education.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractStudentLogin implements LoginService {

    @Autowired
    StudentMapper mapper;

    @Override
    public Result login(String username, String content) {
        Student student=mapper.selectStudentById(username);
        //检查学生状态
        Result result=doLogin(student,content);
        if(!result.isState()) return fail(student);
        else return success(student);
    }
    abstract Result doLogin(Student student,String content);

    private Result success(Student student){
        Map<String,Object> map=new HashMap<>();
        map.put("user",student);
        return Result.ok().code(200).message("学生登录成功").data(map);
    }

    private Result fail(Student student){
        if(student.getFailTime()>5) {
            student.setFailTime(0);
            return Result.error().code(Code.MULTIPLE_LOGIN_ATTEMPT.getCode()).message(Code.MULTIPLE_LOGIN_ATTEMPT.getMess());
        }
        else {
            return Result.error().code(Code.LOGIN_ERROR.getCode()).message(Code.LOGIN_ERROR.getMess());
        }
    }
}
