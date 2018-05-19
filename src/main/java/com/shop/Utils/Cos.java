package com.shop.Utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

public class Cos {
    private static final String region = "ap-chengdu";
    private static final String secretid = "AKIDzxpX4V5vtlT0iQrMchdOWbcS8cv7wLNj";
    private static final String secretkey = "MXeehflppiV7XlzT0RhmgpsHYrzwtlR0";
    private static final String appid = "1256460485";
    private static final String bucketName = "shop" + "-" + appid;


    public static String upload(String type, String fileStr) {
        File file = new File(fileStr);
        COSClient cosClient = getCosClient();


        String[] fileList = fileStr.split("\\.");
        String key = type + new Date().getTime() + "." + fileList[fileList.length - 1];
        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        // 指定要上传到 COS 上的路径

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
        cosClient.putObject(putObjectRequest);
        cosClient.shutdown();
        Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
        URL url = cosClient.generatePresignedUrl(bucketName, key, expiration);
        String str = url.toString().split("\\?sign")[0];
        return str;
    }

    public static String upload(InputStream input,
                                long contentLength,
                                String fileType,
                                String contentType,
                                String uploadDir) {
        COSClient cosClient = getCosClient();
        //唯一标识码
        String key = uploadDir + UUID.randomUUID() + "." + fileType;
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(contentLength);
        objectMetadata.setContentType(contentType);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, input, objectMetadata);
        cosClient.putObject(putObjectRequest);
        cosClient.shutdown();
        Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
        URL url = cosClient.generatePresignedUrl(bucketName, key, expiration);
        String str = url.toString().split("\\?sign")[0];
        return str;
    }

    private static COSClient getCosClient() {
        COSCredentials cred = new BasicCOSCredentials(secretid, secretkey);
        // 2 设置bucket的区域, COS地域的简称请参照
        // https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        // 3 生成cos客户端
        return new COSClient(cred, clientConfig);
    }
}
