package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.service.manage.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/manage")
public class ManageController {
    @Autowired
    ManageService manageService;
    
    @PostMapping("/blockStudent")
    public Result blockStudent(String id) {
        return manageService.blockStudent(id);
    }

    @PostMapping("/unblockStudent")
    public Result unblockStudent(String id) {
        return manageService.unblockStudent(id);
    }
}
