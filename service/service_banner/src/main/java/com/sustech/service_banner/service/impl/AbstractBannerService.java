package com.sustech.service_banner.service.impl;

import com.sustech.commonutils.Result;
import com.sustech.service_banner.entity.Banner;
import com.sustech.service_banner.entity.Page;
import com.sustech.service_banner.mapper.BannerMapper;
import com.sustech.service_banner.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBannerService implements BannerService {
    @Autowired
    protected BannerMapper mapper;
    
    @Override
    public Page getPage(int currentPage, int limit) {
        return null;
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
