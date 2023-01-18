package com.sustech.service_banner.service.impl;

import com.sustech.commonhandler.exception.DatabaseOperationFailureException;
import com.sustech.commonutils.Result;
import com.sustech.service_banner.entity.Banner;
import com.sustech.service_banner.mapper.BannerMapper;
import com.sustech.service_banner.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class AbstractBannerService implements BannerService {
    @Autowired
    protected BannerMapper mapper;

    Random random = new Random();
    @Override
    public Result getBanners() {
        List<Banner> res = mapper.getAllBanner();
        int len = res.size();
        int start = random.nextInt(0,len-3);
        System.out.println(start);
        Map<String, Object> map=new HashMap<>();
        map.put("Banner1",res.get(start));
        map.put("Banner2",res.get(start+1));
        map.put("Banner3",res.get(start+2));
        map.put("Banner4",res.get(start+3));
        return Result.ok().code(200).message("轮播图获取成功").data(map);
    }

    @Override
    public Result deleteBanner(String url) {
        if(mapper.deleteBanner(url) == 0) {
            throw new DatabaseOperationFailureException();
        } else {
            return Result.ok().message("轮播图数据删除成功").code(200);
        }
    }

    @Override
    public Result insertBanner(String url, String course_id) {

        if(mapper.insertBanner(url,course_id) == 0) {
            throw new DatabaseOperationFailureException();
        } else {
            return Result.ok().message("轮播图数据存储成功").code(200);
        }
    }
}
