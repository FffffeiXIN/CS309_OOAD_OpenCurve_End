package com.sustech.service_education.service.login.impl;

import com.sustech.commonutils.Result;
import com.sustech.commonutils.enums.Code;
import com.sustech.service_education.entity.Student;
import com.sustech.service_education.entity.SuperManager;
import com.sustech.service_education.mapper.StudentMapper;
import com.sustech.service_education.mapper.SuperManagerMapper;
import com.sustech.service_education.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public abstract class AbstractManagerLogin implements LoginService {
    Random random = new Random();
    @Autowired
    SuperManagerMapper mapper;

    @Override
    public Result login(String username, String content) {
        SuperManager manager=mapper.selectManagerById(username);
        //检查学生状态
        Result result=doLogin(manager,content);
        if(!result.isState()) return fail(manager);
        else return success(manager);
    }
    abstract Result doLogin(SuperManager manager,String content);

    private Result success(SuperManager manager){
        Map<String,Object> map=new HashMap<>();
        map.put("user",manager);
        return Result.ok().code(200).message("管理员登录成功").data(map);
    }

    private Result fail(SuperManager manager){
//        if(manager.getFailTime()>5) {
//            manager.setFailTime(0);
//            return Result.error().code(Code.MULTIPLE_LOGIN_ATTEMPT.getCode()).message(Code.MULTIPLE_LOGIN_ATTEMPT.getMess());
//        }
//        else {
            return Result.error().code(Code.LOGIN_ERROR.getCode()).message(Code.LOGIN_ERROR.getMess());
//        }
    }
}
