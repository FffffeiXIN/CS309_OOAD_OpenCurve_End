package com.sustech.service_education.service.login;


import com.sustech.commonutils.Result;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public interface LoginService {
    Map<String, LoginService> loginService=new HashMap<>();
    Result login(String username,String content);
}
