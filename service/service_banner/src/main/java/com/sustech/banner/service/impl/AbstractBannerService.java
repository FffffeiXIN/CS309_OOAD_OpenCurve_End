package com.sustech.banner.service.impl;

import com.sustech.banner.entity.Page;
import com.sustech.banner.service.BannerService;

public abstract class AbstractBannerService implements BannerService {
    @Override
    public Page getPage(int currentPage, int limit) {
        return null;
    }

}
