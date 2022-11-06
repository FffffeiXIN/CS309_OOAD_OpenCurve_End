package com.sustech.service_education.controller;

import com.sustech.commonhandler.exception.ServiceNotFoundException;
import com.sustech.commonutils.ReflectUtils;
import com.sustech.commonutils.Result;
import com.sustech.service_education.service.login.LoginService;
import com.sustech.service_education.service.register.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/education/register")
@Api(tags = {"接口测试"})
public class RegisterController {
    RegisterService registerService;

    @GetMapping("getVertiCode")
    @ApiOperation(value = "注册模块发验证码测试")
    public Result getVertiCode(String Email, String type){
        return registerService.getVertiCode(Email, type);
    }

    @GetMapping("doRegister")
    @ApiOperation(value = "注册模块注册时测试")
    public Result doRegister(String Email, String password, String type){
        return registerService.doRegister(Email, password, type);
    }
}
