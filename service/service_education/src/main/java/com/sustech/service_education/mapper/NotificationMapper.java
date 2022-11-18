package com.sustech.service_education.mapper;

import com.sustech.service_education.entity.Notification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationMapper {
    int addNotification(String title, String course_id, String teacher_id, String modified_date, String content);

    List<Notification> getNotificationByCourse(String course_id);

    List<Notification> getNotificationByTeacher(String teacher_id);
}
