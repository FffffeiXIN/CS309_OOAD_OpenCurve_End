package com.sustech.service_education.controller.login;

import com.sustech.commonhandler.exception.ServiceNotFoundException;
import com.sustech.commonutils.ReflectUtils;
import com.sustech.commonutils.Result;
import com.sustech.commonutils.enums.Code;
import com.sustech.service_education.service.login.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/education/login")
public class LoginController {
    @GetMapping("user")
    public Result studentLogin(String userid,String content,String loginType){
        LoginService loginService;
        if(LoginService.loginService.containsKey(loginType)){
            loginService=LoginService.loginService.get(loginType);
        }else {
            String path="com.sustech.service_education.service.login.impl."+loginType;
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
