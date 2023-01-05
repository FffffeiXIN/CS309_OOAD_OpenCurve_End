package com.sustech.service_education.service.teacher;

import com.sustech.commonutils.Result;

public interface TeacherService {
    Result getAllTeachers();

    Result updateInfo(String userId, String name,String department, String gender,String picture_url);

}
