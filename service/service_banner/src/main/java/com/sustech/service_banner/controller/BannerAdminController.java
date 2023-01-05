package com.sustech.service_banner.controller;

import com.sustech.service_banner.entity.Banner;
import com.sustech.service_banner.entity.Page;
import com.sustech.service_banner.service.BannerService;
import com.sustech.commonutils.Result;
import com.sustech.service_banner.service.impl.BannerAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping("/banner")
public class BannerAdminController {
    @Qualifier("BannerAdminService")
    @Autowired
    BannerService service;

    @GetMapping("getBanner")
    public Result getBanner(){
        return service.getBanners();
    }

    @GetMapping("delBanner")
    public Result deleteBanner(String url){
        return service.deleteBanner(url);
    }

    @PostMapping("addBanner")
    public Result addBanner(String url,String group,String path){
        System.out.print("3");
        Banner banner=new Banner();
        banner.setUrl(url);
//        banner.setGroup(group);
//        banner.setPath(path);
        return service.insertBanner(banner);
    }
}
