package com.sustech.service_education.service.manage;

import com.sustech.commonutils.Result;

public interface ManageService {
    Result blockStudent(String id);
    Result unblockStudent(String id);
    Result blockTeacher(String id);
    Result unblockTeacher(String id);
    Result getTeachersInfo();
    Result getStudentsInfo();
}
