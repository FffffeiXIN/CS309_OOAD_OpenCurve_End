package com.sustech.service_education.service.login.impl;

import com.sustech.commonutils.Result;
import com.sustech.commonutils.enums.Code;
import com.sustech.service_education.entity.Student;
import com.sustech.service_education.entity.Teacher;
import com.sustech.service_education.mapper.StudentMapper;
import com.sustech.service_education.mapper.TeacherMapper;
import com.sustech.service_education.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractTeacherLogin implements LoginService {
    @Autowired
    TeacherMapper mapper;

    @Override
    public Result login(String username, String content) {
        Teacher teacher = mapper.selectTeacherByEmail(username);
        //检查老师状态
        Result result=doLogin(teacher,content);
        if(!result.isState()) return fail(teacher);
        else return success(teacher);
    }
    abstract Result doLogin(Teacher teacher,String content);

    private Result success(Teacher teacher){
        Map<String,Object> map=new HashMap<>();
        map.put("user",teacher);
        return Result.ok().code(200).message("老师登录成功").data(map);
    }

    private Result fail(Teacher teacher){
        if(teacher.getFailTime()>5) {
            teacher.setFailTime(0);
            return Result.error().code(Code.MULTIPLE_LOGIN_ATTEMPT.getCode()).message(Code.MULTIPLE_LOGIN_ATTEMPT.getMess());
        }
        else {
            return Result.error().code(Code.LOGIN_ERROR.getCode()).message(Code.LOGIN_ERROR.getMess());
        }
    }

}
