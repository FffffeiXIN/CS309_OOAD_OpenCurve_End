package com.sustech.service_education.service.modifyInfo;

import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Student;
import com.sustech.service_education.entity.SuperManager;
import com.sustech.service_education.entity.Teacher;
import com.sustech.service_education.mapper.StudentMapper;
import com.sustech.service_education.mapper.SuperManagerMapper;
import com.sustech.service_education.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class ModifyInfoService {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    SuperManagerMapper superManagerMapper;
    public Result updateInfo(String id, String name, String department, String college, String grade, String picture_url, String birthday, String gender, String region, String address) {
        studentMapper.update(id, name, department, college, grade, picture_url, birthday, gender,region,address);
        return Result.ok().code(200).message("修改信息成功");
    }

    public Result getInfo(String id, String userType){
        Map<String, Object> map = new HashMap<>();
        if (userType.equals("Student")){
            Student res = studentMapper.selectStudentById(id);
            map.put("Info",res);
        }
        else if (userType.equals("Teacher")){
            Teacher res = teacherMapper.selectTeacherByEmail(id);
            map.put("Info",res);
        }
        else {
            SuperManager res = superManagerMapper.selectManagerById(id);
            map.put("Info",res);
        }
        return Result.ok().message("获取信息成功").data(map);
    }
}
