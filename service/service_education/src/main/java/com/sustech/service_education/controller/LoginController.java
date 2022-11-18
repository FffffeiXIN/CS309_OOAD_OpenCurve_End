package com.sustech.service_education.controller;

import com.sustech.commonhandler.exception.ServiceNotFoundException;
import com.sustech.commonutils.ReflectUtils;
import com.sustech.commonutils.Result;
import com.sustech.service_education.service.login.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/education/login")
@Api(tags = {"接口测试"})
public class LoginController {
    @GetMapping("user")
    @ApiOperation(value = "登录模块测试")
    public Result login(String userid,String content,String loginType) throws UnknownHostException, MessagingException {
        LoginService loginService;
        if(LoginService.loginService.containsKey(loginType)){
            loginService=LoginService.loginService.get(loginType);
        }else {
            String path="com.sustech.service_education.service.login.impl."+loginType+"Impl";
            try {
                loginService= (LoginService) ReflectUtils.createBean(path);
                LoginService.loginService.put(loginType,loginService);
            } catch (Exception e) {
                throw new ServiceNotFoundException();
            }
        }
        return loginService.login(userid,content);
    }

}
