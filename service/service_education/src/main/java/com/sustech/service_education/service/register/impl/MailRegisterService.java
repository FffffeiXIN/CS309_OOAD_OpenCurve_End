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
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import javax.mail.*;
import javax.mail.internet.*;

@Service
public class MailRegisterService implements RegisterService {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherMapper teacherMapper;

    Random random = new Random();

    @Override
    public Result getVertiCode(String Email, String type) throws MessagingException, UnknownHostException {
        if (type.equals("Teacher")){
            Teacher teacher = teacherMapper.selectTeacherByEmail(Email);
            if (teacher != null){
                throw new RepeatRegisterException();
            }
            else {
                String code = sendMail(Email);
//                String contents = String.valueOf(random.nextInt(1000,9999));
                return Result.ok().addData("vertiCode",code);
            }
        }
        else {
            Student student = studentMapper.selectStudentById(Email);
            if (student != null){
                throw new RepeatRegisterException();
            }
            else {
                String code = sendMail(Email);
//                String contents = String.valueOf(random.nextInt(1000,9999));
                return Result.ok().addData("vertiCode",code);
            }
        }
    }

    @Override
    public Result doRegister(String Email, String password, String type) {
        if (type.equals("Teacher")){
            Teacher teacher = new Teacher();
            teacher.setId(Email);
            teacher.setPassword(password);
            teacherMapper.insert(teacher);
            return Result.ok();
        }
        else {
            Student student = new Student();
            student.setId(Email);
            student.setPassword(password);
            studentMapper.insert(student);
            return Result.ok();
        }
    }

    public String sendMail(String mail) throws MessagingException, UnknownHostException {
        Properties props = new Properties();
        props.put("mail.transport.protocol","smtps");
        props.put("mail.smtps.host","smtp.sustech.edu.cn");
        props.put("mail.smtps.user","12012939@mail.sustech.edu.cn");
        props.put("mail.smtps.auth","true");
        Session mailSession = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(mailSession);

        message.setFrom(new InternetAddress("12012939@mail.sustech.edu.cn"));
        message.setRecipients(MimeMessage.RecipientType.TO, mail);
        message.setSubject("OpenCurve注册验证");

        MimeMultipart msgMultipart = new MimeMultipart("mixed");
        message.setContent(msgMultipart);

        MimeBodyPart content = new MimeBodyPart();
        msgMultipart.addBodyPart(content);

        MimeMultipart bodyMultipart = new MimeMultipart("related");
        content.setContent(bodyMultipart);

        MimeBodyPart htmlPart = new MimeBodyPart();
        bodyMultipart.addBodyPart(htmlPart);
        String contents = String.valueOf(random.nextInt(1000,9999));
        htmlPart.setContent(contents, "text/plain;charset=UTF-8");

        Transport transport = mailSession.getTransport();

        String password = "Lyx19970420!";
        transport.connect("12012939@mail.sustech.edu.cn", password);

        transport.sendMessage(message, message.getAllRecipients());

        return contents;

    }
}
