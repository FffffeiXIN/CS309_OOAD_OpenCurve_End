package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.service.modifyInfo.ModifyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/education/Info")
public class ModifyInfoController {
    @Autowired
    ModifyInfoService modifyInfoService;

    @PostMapping("/update")
    public Result updateInfo(String id, String name, String department, String college, String grade, String picture_url, String birthday, String gender, String region, String address) {
        return modifyInfoService.updateInfo(id, name, department, college, grade, picture_url, birthday, gender, region,address);
    }

    @GetMapping("/getInfo")
    public Result getInfo(String id){
        return modifyInfoService.getInfo(id);
    }
}
