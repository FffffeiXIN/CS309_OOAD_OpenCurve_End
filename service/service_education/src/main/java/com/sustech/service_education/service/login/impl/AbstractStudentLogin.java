package com.sustech.service_education.service.login.impl;

import com.sustech.commonutils.Result;
import com.sustech.commonutils.enums.Code;
import com.sustech.service_education.entity.Student;
import com.sustech.service_education.mapper.StudentMapper;
import com.sustech.service_education.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class AbstractStudentLogin implements LoginService {

    Random random = new Random();

    @Autowired
    StudentMapper mapper;

    @Override
    public Result login(String username, String content) throws UnknownHostException, MessagingException {
        Student student=mapper.selectStudentById(username);
        //检查学生状态
        if (student == null){
            return Result.error().code(Code.LOGIN_ERROR.getCode()).message("此用户不存在");
        }
        if (!student.getStatus().equals("normal")){
            return Result.error().code(Code.LOGIN_ERROR.getCode()).message("此账号被冻结");
        }

        Result result = doLogin(student,content);
//        if(!result.isState()) return fail(student);
//        else return success(student);
        result.addData("user",student); // 返回验证码+学生
        return result;
    }
    abstract Result doLogin(Student student,String content) throws UnknownHostException, MessagingException;

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
