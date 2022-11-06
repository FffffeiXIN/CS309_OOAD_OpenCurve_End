package com.sustech.banner.service;

import com.sustech.banner.entity.Banner;
import com.sustech.banner.entity.Page;
import com.sustech.commonutils.Result;

public interface BannerService {

    Page getPage(int currentPage,int limit);

    Result deleteBanner(String url);

    Result addBanner(Banner banner);

}
