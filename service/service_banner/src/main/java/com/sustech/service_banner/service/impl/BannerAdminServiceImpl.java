//package com.sustech.service_banner.service.impl;
//
//import com.sustech.commonhandler.exception.DatabaseOperationFailureException;
//import com.sustech.service_banner.entity.Banner;
//import com.sustech.commonutils.Result;
//import org.springframework.stereotype.Service;
//
//@Service("BannerAdminService")
//public class BannerAdminServiceImpl extends AbstractBannerService {
//
//    @Override
//    public Result doInsert(String url, String course_id) {
//        if(mapper.insertBanner(url,course_id) == 0) {
//            throw new DatabaseOperationFailureException();
//        } else {
//            return Result.ok().message("轮播图数据存储成功").code(200);
//        }
//    }
//
//    @Override
//    public Result doDelete(String url) {
//        if(mapper.deleteBanner(url) == 0) {
//            throw new DatabaseOperationFailureException();
//        } else {
//            return Result.ok().message("轮播图数据删除成功").code(200);
//        }
//    }
//}
