package com.sustech.service_education.service.login.impl;

import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Student;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Random;

public class StudentTelLoginServiceImpl extends AbstractStudentLogin {
    Random random = new Random();
    @Override
    Result doLogin(Student student, String content) throws UnknownHostException, MessagingException {
        String code = sendMail(student.getId());
        return Result.ok().addData("vertiCode",code);
    }

    public String sendMail(String mail) throws MessagingException, UnknownHostException {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.sustech.edu.cn");
        props.put("mail.smtps.user", "12012939@mail.sustech.edu.cn");
        props.put("mail.smtps.auth", "true");
        Session mailSession = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(mailSession);

        message.setFrom(new InternetAddress("12012939@mail.sustech.edu.cn"));
        message.setRecipients(MimeMessage.RecipientType.TO, mail);
        message.setSubject("OpenCurve登录验证");

        MimeMultipart msgMultipart = new MimeMultipart("mixed");
        message.setContent(msgMultipart);

        MimeBodyPart content = new MimeBodyPart();
        msgMultipart.addBodyPart(content);

        MimeMultipart bodyMultipart = new MimeMultipart("related");
        content.setContent(bodyMultipart);

        MimeBodyPart htmlPart = new MimeBodyPart();
        bodyMultipart.addBodyPart(htmlPart);
        String contents = String.valueOf(random.nextInt(1000, 9999));
        htmlPart.setContent(contents, "text/plain;charset=UTF-8");

        Transport transport = mailSession.getTransport();

        String password = "lYX19970420";
        transport.connect("12012939@mail.sustech.edu.cn", password);

        transport.sendMessage(message, message.getAllRecipients());

        return contents;
    }
}
