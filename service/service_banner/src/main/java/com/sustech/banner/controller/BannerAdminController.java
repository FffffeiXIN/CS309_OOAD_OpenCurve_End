package com.sustech.banner.controller;

import com.sustech.banner.entity.Banner;
import com.sustech.banner.entity.Page;
import com.sustech.banner.service.BannerService;
import com.sustech.commonutils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/banner/admin")
public class BannerAdminController {

    @Autowired
    BannerService service;

    @GetMapping("getBanner")
    public Result getBanner(Integer currentPage,Integer limit){
        Page page= service.getPage(currentPage,limit);
        Map<String, Object> map=new HashMap<>();
        map.put("pages",page.getUrls());
        map.put("total",page.getTotalNum());
        return Result.ok().code(200).message("").data(map);
    }

    @GetMapping("delBanner")
    public Result deleteBanner(String url){
        return service.deleteBanner(url);
    }

    @GetMapping("addBanner")
    public Result addBanner(String url,String group,String path){
        Banner banner=new Banner();
        banner.setUrl(url);
        banner.setGroup(group);
        banner.setPath(path);
        return service.addBanner(banner);
    }



}
