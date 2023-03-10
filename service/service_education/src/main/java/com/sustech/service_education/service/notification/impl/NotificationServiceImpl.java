package com.sustech.service_education.service.notification.impl;

import com.sustech.commonhandler.exception.DatabaseOperationFailureException;
import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.*;
import com.sustech.service_education.mapper.*;
import com.sustech.service_education.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.net.UnknownHostException;
import java.util.*;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationMapper notificationMapper;

    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    SuperManagerMapper superManagerMapper;

    @Override
    public Result addNotification(String title, String course_id, String teacher_id, String modified_date, String content) {
        int success = notificationMapper.addNotification(title, course_id, teacher_id, modified_date, content);
        if (success == 0) {
            throw new DatabaseOperationFailureException();
        } else {
            return Result.ok().message("通知添加成功").code(200);
        }
    }

    @Override
    public Result getAllNotifications() {
        List<Notification> notifications = notificationMapper.getAllNotifications();
        Map<String, Object> map = new HashMap<>();
        map.put("notifications", notifications);

        return Result.ok().message("获取全部通知成功").data(map);
    }

    @Override
    public Result getNotificationsByCourse(String course_id) {
        List<Notification> notifications = notificationMapper.getNotificationByCourse(course_id);

        Map<String, Object> map = new HashMap<>();
        map.put("notifications", notifications);

        return Result.ok().message("获取课程通知成功").data(map);
    }

    @Override
    public Result getNotificationByTeacher(String teacher_id) {
        Map<String, Object> map = new HashMap<>();
        Teacher teacher = teacherMapper.selectTeacherByEmail(teacher_id);
        String str = teacher.getDepartment() + "000";
        List<Notification> notifications = new ArrayList<>(notificationMapper.getNotificationByCourse(str));

        List<Course> courses = courseMapper.getCoursesOfTeacher(teacher_id);
        for (Course cours : courses) {
            String course_id = cours.getId();
            notifications.addAll(notificationMapper.getNotificationByCourse(course_id));
        }

        map.put("teacherDepartment", teacher.getDepartment());
        map.put("courses", courses);
        map.put("notifications", notifications);
        return Result.ok().code(200).message("教师获取通知成功").data(map);
    }

    @Override
    public Result getNotificationByManager(String manager_id) {
        Map<String, Object> map = new HashMap<>();
        SuperManager manager = superManagerMapper.selectManagerById(manager_id);
        String str = manager.getDepartment() + "000";
        List<Notification> notification = notificationMapper.getNotificationByCourse(str);
        map.put("notifications", notification);
        return Result.ok().code(200).message("管理员获取通知成功").data(map);
    }

    @Override
    public Result getNotificationByStudent(String student_id) {
        Map<String, Object> map = new HashMap<>();
        Student student = studentMapper.selectStudentById(student_id);
        String str = student.getDepartment() + "000";
        List<Notification> notifications = new ArrayList<>(notificationMapper.getNotificationByCourse(str));

        List<Course> courses = courseMapper.getCoursesOfStudent(student_id);
        for (Course cours : courses) {
            String course_id = cours.getId();
            notifications.addAll(notificationMapper.getNotificationByCourse(course_id));
        }

        map.put("studentDepartment", student.getDepartment());
        map.put("courses", courses);
        map.put("notifications", notifications);
        return Result.ok().code(200).message("学生获取通知成功").data(map);
    }

    @Override
    public Result sendMailToStudents(String course_id, String title, String content) {
        List<Student> students = courseMapper.getStudentsByCourse(course_id);
        try {
            for (Student s : students) {
                String email = s.getId();
                sendMail(email, course_id, title, content);
            }
        } catch (MessagingException | UnknownHostException e) {
            throw new RuntimeException(e);
        }

        return Result.ok().message("邮件发送成功");
    }

    public void sendMail(String mail, String course_id, String title, String contents) throws MessagingException, UnknownHostException {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.sustech.edu.cn");
        props.put("mail.smtps.user", "12012939@mail.sustech.edu.cn");
        props.put("mail.smtps.auth", "true");
        Session mailSession = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(mailSession);

        message.setFrom(new InternetAddress("12012939@mail.sustech.edu.cn"));
        message.setRecipients(MimeMessage.RecipientType.TO, mail);
        message.setSubject("您的课程有新通知发布");

        MimeMultipart msgMultipart = new MimeMultipart("mixed");
        message.setContent(msgMultipart);

        MimeBodyPart content = new MimeBodyPart();
        msgMultipart.addBodyPart(content);

        MimeMultipart bodyMultipart = new MimeMultipart("related");
        content.setContent(bodyMultipart);

        MimeBodyPart htmlPart = new MimeBodyPart();
        bodyMultipart.addBodyPart(htmlPart);
        String send_message = "课程" + course_id + "发布新通知：\n"
                + "通知题目： " + title + "\n内容：" + contents;
        htmlPart.setContent(send_message, "text/plain;charset=UTF-8");

        Transport transport = mailSession.getTransport();

        String password = "Lyx19970420!";
        transport.connect("12012939@mail.sustech.edu.cn", password);

        transport.sendMessage(message, message.getAllRecipients());

    }
}
