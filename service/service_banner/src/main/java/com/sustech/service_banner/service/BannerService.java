package com.sustech.service_banner.service;

import com.sustech.service_banner.entity.Banner;
import com.sustech.service_banner.entity.Page;
import com.sustech.commonutils.Result;

import java.util.List;

public interface BannerService {

    Result getBanners();

    Result deleteBanner(String url);

    Result insertBanner(Banner banner);

}
