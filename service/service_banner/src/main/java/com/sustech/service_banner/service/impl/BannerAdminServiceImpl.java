package com.sustech.service_banner.service.impl;

import com.sustech.service_banner.entity.Banner;
import com.sustech.commonutils.Result;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component("BannerAdminService")
public class BannerAdminServiceImpl extends AbstractBannerService {
    @Override
    public Result deleteBanner(String url) {
        return null;
    }

    @Override
    public Result addBanner(Banner banner) {
        return null;
    }
}
