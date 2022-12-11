package com.sustech.service_banner.mapper;

import com.sustech.commonutils.Result;
import com.sustech.service_banner.entity.Banner;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BannerMapper {

    int insertBanner(Banner banner);

    int deleteBanner(String url);
}
