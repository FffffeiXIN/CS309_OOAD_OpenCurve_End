package com.sustech.service_banner.controller;

import com.sustech.service_banner.entity.Page;
import com.sustech.service_banner.service.BannerService;
import com.sustech.commonutils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/banner")
public class BannerFrontController {
    @Qualifier("BannerFrontService")
    @Autowired
    BannerService service;
    
    @GetMapping("getBanner")
    public Result getBanner(Integer currentPage, Integer limit){
        Page page= service.getPage(currentPage,limit);
        Map<String, Object> map=new HashMap<>();
        map.put("pages",page.getUrls());
        map.put("total",page.getTotalNum());
        return Result.ok().code(200).message("").data(map);
    }
}
