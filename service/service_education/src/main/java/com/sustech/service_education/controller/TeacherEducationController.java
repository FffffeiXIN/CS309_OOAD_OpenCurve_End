package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Course;
import com.sustech.service_education.entity.Teacher;
import com.sustech.service_education.entity.User;
import com.sustech.service_education.service.TeacherEducationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@Api(value = "接口测试类" , tags = "教师接口测试类")
public class TeacherEducationController extends BaseEducationController{

    @Autowired
    private TeacherEducationService teacherService;

    @GetMapping("list")
    @ApiOperation(value = "查询全部教师")
    public Result queryAllTeacher(){
        List<Teacher> teachers=teacherService.queryAll();
        return Result.ok().addData("teachers",teachers).message("包含所有的老师对象信息");
    }

    public Result createCourse(Course course){
        return Result.error();
    }

}
