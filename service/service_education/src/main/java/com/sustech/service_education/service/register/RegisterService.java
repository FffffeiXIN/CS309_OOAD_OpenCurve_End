package com.sustech.service_education.service.register;

import com.sustech.commonutils.Result;
import org.springframework.stereotype.Service;

public interface RegisterService {
    Result getVertiCode(String Email, String type);
    Result doRegister(String Email, String password, String type);
}
