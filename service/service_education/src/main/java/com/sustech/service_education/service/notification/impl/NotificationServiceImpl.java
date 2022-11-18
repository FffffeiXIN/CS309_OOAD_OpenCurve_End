package com.sustech.service_education.service.notification.impl;

import com.sustech.commonhandler.exception.InsertionFailureException;
import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Notification;
import com.sustech.service_education.mapper.NotificationMapper;
import com.sustech.service_education.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationMapper mapper;

    @Override
    public Result addNotification(String title, String course_id, String teacher_id, String modified_date, String content) {
        int success = mapper.addNotification(title, course_id, teacher_id, modified_date, content);
        if (success == 0) {
            throw new InsertionFailureException();
        } else {
            return Result.ok().message("通知添加成功").code(200);
        }
    }

    @Override
    public Result getNotificationsByCourse(String course_id) {
        List<Notification> notifications = mapper.getNotificationByCourse(course_id);

        Map<String, Object> map = new HashMap<>();
        map.put("notifications", notifications);

        return Result.ok().message("获取课程通知成功").data(map);
    }

    @Override
    public Result getNotificationByTeacher(String teacher_id) {
        List<Notification> notifications = mapper.getNotificationByTeacher(teacher_id);

        Map<String, Object> map = new HashMap<>();
        map.put("notifications", notifications);

        return Result.ok().message("获取教师通知成功").data(map);
    }
}
