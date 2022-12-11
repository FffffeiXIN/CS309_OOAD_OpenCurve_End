package com.sustech.service_banner.service;

import com.sustech.service_banner.entity.Banner;
import com.sustech.service_banner.entity.Page;
import com.sustech.commonutils.Result;

public interface BannerService {

    Page getPage(int currentPage,int limit);

    Result deleteBanner(String url);

    Result insertBanner(Banner banner);

}
