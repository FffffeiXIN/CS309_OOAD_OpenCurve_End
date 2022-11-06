package com.sustech.banner.service.impl;
import com.sustech.banner.entity.Banner;
import com.sustech.commonhandler.exception.InsufficientPermissionException;
import com.sustech.commonutils.Result;

public class BannerFrontServiceImpl extends AbstractBannerService {
    @Override
    public Result deleteBanner(String url) {
        throw new InsufficientPermissionException();
    }

    @Override
    public Result addBanner(Banner banner) {
        throw new InsufficientPermissionException();
    }
}
