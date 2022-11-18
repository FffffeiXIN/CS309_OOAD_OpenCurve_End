package com.sustech.service_banner.service.impl;

import com.sustech.service_banner.entity.Page;
import com.sustech.service_banner.mapper.BannerMapper;
import com.sustech.service_banner.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractBannerService implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    
    @Override
    public Page getPage(int currentPage, int limit) {
        return null;
    }

}
