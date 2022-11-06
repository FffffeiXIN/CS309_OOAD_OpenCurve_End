package com.sustech.service_education.service.register;

import com.sustech.commonutils.Result;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.net.UnknownHostException;

public interface RegisterService {
    Result getVertiCode(String Email, String type) throws MessagingException, UnknownHostException;
    Result doRegister(String Email, String password, String type);
}
