package com.sustech.service_education.service.register.impl;

import com.sustech.commonhandler.GlobalExceptionHandler;
import com.sustech.commonhandler.exception.RepeatRegisterException;
import com.sustech.commonutils.Result;
import com.sustech.commonutils.enums.Code;
import com.sustech.service_education.entity.Student;
import com.sustech.service_education.entity.Teacher;
import com.sustech.service_education.mapper.TeacherMapper;
import com.sustech.service_education.mapper.StudentMapper;
import com.sustech.service_education.service.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.*;
import javax.mail.internet.*;

@Service
public class MailRegisterService implements RegisterService {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Result getVertiCode(String Email, String type) {
        if (type.equals("teacher")){
            Teacher teacher = teacherMapper.selectTeacherByEmail(Email);
            if (teacher != null){
                throw new RepeatRegisterException();
            }
            else {

            }
        }
        else {
            Student student = studentMapper.selectStudentById(Email);
            if (student != null){
                throw new RepeatRegisterException();
            }
            else {

            }
        }
    }

    @Override
    public Result doRegister(String Email, String password, String type) {
        return null;
    }

    public void sendMail(){
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("src/main/resources/mail.properties")))
        {
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Password: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();

        Session mailSession = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(mailSession);
    }
}
