package com.sustech.cloud_storage.controller;

import com.sustech.cloud_storage.service.FileUploadingService;
import com.sustech.commonutils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@CrossOrigin
@RequestMapping("/cloud_storage/file")
public class FileUploadingController {

    @Autowired
    private FileUploadingService fileUploadingService;


    @PostMapping("uploading")
    public Result upload(MultipartFile file){
        String url= fileUploadingService.upload(file);
        return Result.ok().addData("url",url);
    }


}
