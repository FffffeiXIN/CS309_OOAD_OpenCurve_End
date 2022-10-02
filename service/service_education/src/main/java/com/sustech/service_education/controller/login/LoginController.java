package com.sustech.service_education.controller.login;

import com.sustech.commonutils.Result;
import com.sustech.commonutils.enums.Code;
import com.sustech.service_education.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/education/login")
public class LoginController {

    @GetMapping("student")
    public Result studentLogin(String userid,String content,String loginType){
        LoginService loginService=LoginService.loginService.get(loginType);
        if(loginService==null) return Result.error().code(Code.N0_SERVICE_ERROR.getCode()).message(Code.N0_SERVICE_ERROR.getMess());
        return loginService.login(userid,content);
    }

    @GetMapping("teacher")
    public Result teacherLogin(String userid,String content,String loginType){
        return Result.error();
    }

}
