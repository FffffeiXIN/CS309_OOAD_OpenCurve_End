package com.sustech.service_education.controller;


import com.sustech.commonutils.Result;
import com.sustech.service_education.entity.Teacher;
import com.sustech.service_education.entity.User;
import com.sustech.service_education.service.StudentEducationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/service_education/student")
@Api(value = "接口测试类" , tags = "学生接口测试类")
public class StudentEducationController extends BaseEducationController {


    @Autowired
    private StudentEducationService studentService;

    @ApiOperation(value = "学生选课")
    public Result chooseCourse(){
        return Result.error();
    }
    @PostMapping("login")
    @ApiOperation(value = "学生登陆")
    public Result login(int id,String passwd){
        boolean flag = studentService.checkStudent(id, passwd);
        if(flag) return Result.ok();
        else return Result.error();
    }



    public Result register(User user){
        return Result.error();
    }



}
