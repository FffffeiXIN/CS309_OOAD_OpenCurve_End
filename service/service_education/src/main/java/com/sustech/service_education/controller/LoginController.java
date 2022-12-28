package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.service.login.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/education/login")
@Api(tags = {"接口测试"})
@CrossOrigin
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("/user")
    @ApiOperation(value = "登录模块测试")
    public Result login(String userId, String content, String userType, String loginWay){
// Type: Student Teacher Admin   WAY: Password /  Verification Code
        if (userType.equals("Student"))
            return loginService.studentLogin(userId,content,loginWay);
        else if (userType.equals("Teacher"))
            return loginService.teacherLogin(userId,content,loginWay);
        else
            return loginService.managerLogin(userId,content,loginWay);
    }
}