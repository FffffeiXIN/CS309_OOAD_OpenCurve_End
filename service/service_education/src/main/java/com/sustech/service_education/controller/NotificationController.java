package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/education/notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @GetMapping("/getNotificationByCourse")
    public Result getNotificationByCourse(String course_id){
        return notificationService.getNotificationsByCourse(course_id);
    }

    @GetMapping("/getNotificationByTeacher")
    public Result getNotificationByTeacher(String teacher_id){
        return notificationService.getNotificationByTeacher(teacher_id);
    }

    @PostMapping("/addNotification")
    public Result addNotification(String title, String course_id, String teacher_id, String modified_date, String content){
        return notificationService.addNotification(title, course_id, teacher_id, modified_date, content);
    }
}
