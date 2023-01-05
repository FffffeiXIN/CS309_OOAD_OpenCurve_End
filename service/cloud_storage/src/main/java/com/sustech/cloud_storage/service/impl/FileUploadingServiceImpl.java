package com.sustech.cloud_storage.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.qcloud.cos.utils.IOUtils;
import com.sustech.cloud_storage.service.FileUploadingService;
import com.sustech.cloud_storage.util.OSSConfig;
import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;

import java.io.*;
import java.util.ArrayList;

@Service
public class FileUploadingServiceImpl implements FileUploadingService {
    @Override
    public String upload(MultipartFile file) {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = OSSConfig.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId =OSSConfig.KEY_ID;
        String accessKeySecret = OSSConfig.KEY_SECRET;
        // 填写Bucket名称，例如examplebucket。
        String bucketName = OSSConfig.BUCKET_NAME;
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = file.getOriginalFilename();
        // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        String url="https://"+bucketName+"."+endpoint+"/"+objectName;

        try {
            InputStream inputStream = file.getInputStream();
            // 创建PutObject请求。
            ossClient.putObject(bucketName, objectName, inputStream);
        } catch (OSSException oe) {
            throw new OSSException();
        } catch (ClientException ce) {
            throw new ClientException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return url;
    }
    
    @Override
    public String uploadVideo(MultipartFile file) {
        String tempPath = "D:\\";
        String fileName = file.getOriginalFilename();
        fileName = tempPath + fileName;
        InputStream inputStream = null;
        FileOutputStream fileOut = null;
        String urls = "";
        try {
            inputStream = file.getInputStream();
            fileOut = new FileOutputStream(fileName);
            IOUtils.copy(inputStream, fileOut);
            fileOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOut != null) {
                    fileOut.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            compressVideo(fileName, fileName + "_medium.mkv", 2);
            File compressed = new File(fileName + "_medium.mkv");
            FileInputStream is = new FileInputStream(compressed);
            MultipartFile multipartFile = new MockMultipartFile(compressed.getName(), compressed.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(), is);
            urls = urls + "`" +this.upload(multipartFile);
            
            compressVideo(fileName, fileName + "_low.mkv", 3);
            compressed = new File(fileName + "_low.mkv");
            is = new FileInputStream(compressed);
            multipartFile = new MockMultipartFile(compressed.getName(), compressed.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(), is);
            urls = urls + "`" +this.upload(multipartFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        urls = urls + "`" + this.upload(file);
        return urls;
    }
    
    private int getBitRate(String videoPath) throws IOException {
        String ffprobePath = new File("").getAbsolutePath() + "\\";
        File ffprobe = new File(ffprobePath + "ffprobe.exe");
        if (!ffprobe.exists() && !ffprobe.canExecute()) {
            System.err.println("Check if ffprobe.exe exists in the project root directory and is executable!");
        }
        Runtime run = Runtime.getRuntime();
        String command = ffprobePath + "ffprobe.exe -show_streams -i " + videoPath + " 2>nul | findstr /B bit_rate";
        Process p = run.exec(new String[]{
                "cmd",
                "/c",
                command
        }, null, new File(ffprobePath));
        int br = 0;
        try (InputStream err = p.getErrorStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(err));
            String str = reader.readLine();
            while(str != null) {
                System.out.println(str);
                str = reader.readLine();
            }
            reader.close();
        }
        try (InputStream ret = p.getInputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(ret));
            String str = reader.readLine();
            while (str == null || !str.startsWith("bit_rate=")) {
                str = reader.readLine();
            }
            if (str.startsWith("bit_rate=")) {
                br = Integer.parseInt(str.replace("bit_rate=", ""));
            }
        }
        return br;
    }
    
    private void compressVideo(String input, String output, int compressFactor) throws IOException {
        String ffmpegPath = new File("").getAbsolutePath() + "\\";
        File ffmpeg = new File(ffmpegPath + "ffmpeg.exe");
        if (!ffmpeg.exists() && !ffmpeg.canExecute()) {
            System.err.println("Check if ffmpeg.exe exists in the project root directory and is executable!");
        }
        ArrayList<String> command = new ArrayList<>();
        command.add(ffmpegPath + "ffmpeg.exe");
        command.add("-i");
        command.add(input);
        command.add("-b:v");
        command.add(getBitRate(input)/1000/compressFactor + "k");
        command.add(output);
        ProcessBuilder builder = new ProcessBuilder(command);
        Process process;
        try {
            process = builder.start();
            try (InputStream stderr = process.getErrorStream()) {
                BufferedReader errReader = new BufferedReader(new InputStreamReader(stderr));
                String l;
                while ((l = errReader.readLine()) != null) {
                    System.out.println(l);
                }
            }
            try (InputStream stdout = process.getInputStream()) {
                BufferedReader errReader = new BufferedReader(new InputStreamReader(stdout));
                String l;
                while ((l = errReader.readLine()) != null) {
                    System.out.println(l);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
