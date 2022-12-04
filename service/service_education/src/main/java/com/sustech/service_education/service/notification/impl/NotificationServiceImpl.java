package com.sustech.service_education.service.notification.impl;

import com.sustech.commonhandler.exception.InsertionFailureException;
import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Course;
import com.sustech.service_education.entity.Notification;
import com.sustech.service_education.entity.SuperManager;
import com.sustech.service_education.entity.Teacher;
import com.sustech.service_education.mapper.CourseMapper;
import com.sustech.service_education.mapper.NotificationMapper;
import com.sustech.service_education.mapper.SuperManagerMapper;
import com.sustech.service_education.mapper.TeacherMapper;
import com.sustech.service_education.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    NotificationMapper notificationMapper;

    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    SuperManagerMapper superManagerMapper;

    @Override
    public Result addNotification(String title, String course_id, String teacher_id, String modified_date, String content) {
        int success = notificationMapper.addNotification(title, course_id, teacher_id, modified_date, content);
        if (success == 0) {
            throw new InsertionFailureException();
        } else {
            return Result.ok().message("通知添加成功").code(200);
        }
    }

//    @Override
//    public Result getNotificationsByCourse(String course_id) {
//        List<Notification> notifications = mapper.getNotificationByCourse(course_id);
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("notifications", notifications);
//
//        return Result.ok().message("获取课程通知成功").data(map);
//    }

    @Override
    public Result getNotificationByTeacher(String teacher_id) {
        Map<String, Object> map = new HashMap<>();
        Teacher teacher = teacherMapper.selectTeacherByEmail(teacher_id);
        String str = teacher.getDepartment()+"000";
        List<Notification> notification1 = notificationMapper.getNotificationByCourse(str);
        map.put("notification of manager", notification1);

        List<Course> courses = courseMapper.getCoursesOfTeacher(teacher_id);
        for (int i = 0; i < courses.size(); i++) {
            String course_id = courses.get(i).getId();
            List<Notification> notification2 = notificationMapper.getNotificationByCourse(course_id);
            map.put(course_id, notification2);
        }
        return Result.ok().code(200).message("获取教师通知成功").data(map);
    }

    @Override
    public Result getNotificationByManager(String manager_id) {
        Map<String, Object> map = new HashMap<>();
        SuperManager manager = superManagerMapper.selectManagerById(manager_id);
        String str = manager.getDepartment() + "000";
        List<Notification> notification1 = notificationMapper.getNotificationByCourse(str);
        map.put("notification of manager", notification1);
        return Result.ok().code(200).message("获取管理员通知成功").data(map);
    }
}
