package com.sustech.service_banner.service.impl;
import com.sustech.service_banner.entity.Banner;
import com.sustech.commonhandler.exception.InsufficientPermissionException;
import com.sustech.commonutils.Result;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component("BannerFrontService")
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
