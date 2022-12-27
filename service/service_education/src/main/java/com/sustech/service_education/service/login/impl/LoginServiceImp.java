package com.sustech.service_education.service.login.impl;

import com.sustech.commonutils.Result;
import com.sustech.commonutils.enums.Code;
import com.sustech.service_education.entity.Student;
import com.sustech.service_education.entity.SuperManager;
import com.sustech.service_education.entity.Teacher;
import com.sustech.service_education.mapper.StudentMapper;
import com.sustech.service_education.mapper.SuperManagerMapper;
import com.sustech.service_education.mapper.TeacherMapper;
import com.sustech.service_education.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    SuperManagerMapper managerMapper;

//    @Override
//    public Result StudentLogin(String username, String content) throws UnknownHostException, MessagingException {
//        Student student=mapper.selectStudentById(username);
//        //检查学生状态
//        if (student == null){
//            return Result.error().code(Code.LOGIN_ERROR.getCode()).message("此用户不存在");
//        }
//        if (student.isLocked()){
//            return Result.error().code(Code.LOGIN_ERROR.getCode()).message("此账号被冻结");
//        }
//
//        Result result = doLogin(student,content);
////        if(!result.isState()) return fail(student);
////        else return success(student);
//        result.addData("user",student); // 返回验证码+学生
//        return result;
//    }
//     Result doLogin(Student student,String content) throws UnknownHostException, MessagingException;

//    private Result success(Student student){
//        Map<String,Object> map=new HashMap<>();
//        map.put("user",student);
//        return Result.ok().code(200).message("学生登录成功").data(map);
//    }

    @Override
    public Result studentLogin(String username, String content, String type) {
        Student student = studentMapper.selectStudentById(username);
        if (student == null){
            return Result.error().code(Code.LOGIN_ERROR.getCode()).message("此用户不存在");
        }
        if (!student.getStatus().equals("normal")){
            return Result.error().code(Code.LOGIN_ERROR.getCode()).message("此账号被冻结");
        }
        Map<String,Object> map=new HashMap<>();
        map.put("user",student);
        if (type.equals("Password")){
            if(student.comparePassword(content))
                return Result.ok().message("密码登陆成功").code(200).data(map);
            else
                return Result.error().message("密码错误").code(Code.LOGIN_ERROR.getCode());
        }
        else
            return Result.ok().message("验证码登陆成功").code(200).data(map);
    }

    @Override
    public Result teacherLogin(String username, String content, String type) {
        Teacher teacher = teacherMapper.selectTeacherByEmail(username);
        if (teacher == null){
            return Result.error().code(Code.LOGIN_ERROR.getCode()).message("此用户不存在");
        }
        if (!teacher.getStatus().equals("normal")){
            return Result.error().code(Code.LOGIN_ERROR.getCode()).message("此账号被冻结");
        }
        Map<String,Object> map=new HashMap<>();
        map.put("user",teacher);
        if (type.equals("Password")){
            if(teacher.comparePassword(content))
                return Result.ok().message("密码登陆成功").code(200).data(map);
            else
                return Result.error().message("密码错误").code(Code.LOGIN_ERROR.getCode());
        }
        else
            return Result.ok().message("验证码登陆成功").code(200).data(map);
    }

    @Override
    public Result managerLogin(String username, String content, String type) {
        SuperManager manager = managerMapper.selectManagerById(username);
        if (manager == null){
            return Result.error().code(Code.LOGIN_ERROR.getCode()).message("此用户不存在");
        }
        Map<String,Object> map=new HashMap<>();
        map.put("user",manager);
        if (type.equals("Password")){
            if(manager.comparePassword(content))
                return Result.ok().message("密码登陆成功").code(200).data(map);
            else
                return Result.error().message("密码错误").code(Code.LOGIN_ERROR.getCode());
        }
        else
            return Result.ok().message("验证码登陆成功").code(200).data(map);
    }
}
