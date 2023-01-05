package com.sustech.service_banner.service.impl;

import com.sustech.commonutils.Result;
import com.sustech.service_banner.entity.Banner;
import com.sustech.service_banner.entity.Page;
import com.sustech.service_banner.mapper.BannerMapper;
import com.sustech.service_banner.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class AbstractBannerService implements BannerService {
    @Autowired
    protected BannerMapper mapper;

    Random random = new Random();
    @Override
    public Result getBanners() {
        List<Banner> res = mapper.getAllBanner();
        int len = res.size();
        int start = random.nextInt(0,len-3);
        Map<String, Object> map=new HashMap<>();
        map.put("Banner1",res.get(start));
        map.put("Banner2",res.get(start+1));
        map.put("Banner3",res.get(start+2));
        map.put("Banner4",res.get(start+3));
        return Result.ok().code(200).message("轮播图获取成功").data(map);
    }

    @Override
    public Result deleteBanner(String url) {
        return doDelete(url);
    }

    @Override
    public Result insertBanner(Banner banner) {
        
        return doInsert(banner);
    }
    
    public abstract Result doInsert(Banner banner);
    
    public abstract Result doDelete(String url);
}
