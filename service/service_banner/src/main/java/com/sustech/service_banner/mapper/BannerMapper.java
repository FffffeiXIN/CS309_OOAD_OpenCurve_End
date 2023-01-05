package com.sustech.service_banner.mapper;

import com.sustech.commonutils.Result;
import com.sustech.service_banner.entity.Banner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {

    int insertBanner(Banner banner);

    int deleteBanner(String url);

    List<Banner> getAllBanner();
}
