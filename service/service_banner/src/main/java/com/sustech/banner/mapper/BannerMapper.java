package com.sustech.banner.mapper;

import com.sustech.banner.entity.Banner;

import java.util.List;

public interface BannerMapper {

    int insertBanner(Banner banner);

    void deleteBanner(String url);
}
