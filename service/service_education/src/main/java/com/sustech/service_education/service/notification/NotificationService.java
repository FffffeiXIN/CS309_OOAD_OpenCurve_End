package com.sustech.service_education.service.notification;

import com.sustech.commonutils.Result;

public interface NotificationService {
    Result addNotification(String title, String course_id, String teacher_id, String modified_date, String content);

    Result getNotificationsByCourse(String course_id);
    Result getNotificationByTeacher(String teacher_id);
    Result getNotificationByManager(String manager_id);
    Result getNotificationByStudent(String student_id);
    Result sendMailToStudents(String course_id, String title, String content);
}
