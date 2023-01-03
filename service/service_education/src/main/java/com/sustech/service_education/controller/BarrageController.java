package com.sustech.service_education.controller;

import com.sustech.commonutils.Result;
import com.sustech.service_education.service.video.BarrageService;
import com.sustech.service_education.service.video.impl.BarrageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/education/barrage")
public class BarrageController {

    @Autowired
    private BarrageServiceImpl service;

    @PostMapping("/save")
    public Result saveBarrage(int session_id, String text, double time) {
        return service.saveBarrage(session_id, text, time);
    }

    @GetMapping("/list")
    public Result getBarrage(int session_id) {
        return service.getBarrage(session_id);
    }

}
