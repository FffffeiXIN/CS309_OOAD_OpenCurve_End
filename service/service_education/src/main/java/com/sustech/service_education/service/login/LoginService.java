package com.sustech.service_education.service.login;


import com.sustech.commonutils.Result;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface LoginService {
    Map<String, LoginService> loginService = new ConcurrentHashMap<>();
    Result login(String username,String content);
}
