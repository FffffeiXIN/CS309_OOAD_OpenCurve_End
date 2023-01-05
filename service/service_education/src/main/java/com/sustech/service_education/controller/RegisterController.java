package com.sustech.service_education.controller;

import com.sustech.commonhandler.exception.ServiceNotFoundException;
import com.sustech.commonutils.ReflectUtils;
import com.sustech.commonutils.Result;
import com.sustech.service_education.service.login.LoginService;
import com.sustech.service_education.service.register.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/education/register")
//@Api(tags = {"接口测试"})
@CrossOrigin
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping("getVertiCode")
    @ApiOperation(value = "注册模块发验证码测试")
    public Result getVertiCode(String Email, String type) throws MessagingException, UnknownHostException {
        return registerService.getVertiCode(Email, type);
    }

    @PostMapping("doRegister")
    @ApiOperation(value = "注册模块注册时测试")
    public Result doRegister(String Email, String password, String type){
        return registerService.doRegister(Email, password, type);
    }
}
