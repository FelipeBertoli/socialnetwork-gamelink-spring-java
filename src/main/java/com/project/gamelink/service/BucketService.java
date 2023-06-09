package com.project.gamelink.service;

import java.io.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.project.gamelink.repository.BucketRepository;

@Service
public class BucketService implements BucketRepository{

    @Value("${aws.bucket}")
    private String bucket;

    @Value("${aws.access}")
    private String accessKey;

    private String newName;
    private final AmazonS3 s3;

    public BucketService(AmazonS3 s3) {
        this.s3 = s3;
    }

    
    public String getUrl(){
        return s3.getUrl(bucket, accessKey).toString();
    }

    @Override
    public String saveFile(MultipartFile file, String name, String date) {
        String fileName = file.getOriginalFilename();
        int lastDotIndex = fileName.lastIndexOf(".");
        String extension = fileName.substring(lastDotIndex + 1);
    
        newName = name + "-" + date + "." + extension;
        try {
            File newFile = convertMultiPartToFile(file);
            PutObjectResult result = s3.putObject(bucket, newName, newFile);
            return result.getContentMd5();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public byte[] downloadFile(String fileName) {

        throw new UnsupportedOperationException("Unimplemented method 'downloadFile'");
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convertedFile);
        fos.write(file.getBytes());
        fos.close();
        return convertedFile;
    }


    @Override
    public String getUrl(MultipartFile file, String name, String date) {
        String fileName = file.getOriginalFilename();
        int lastDotIndex = fileName.lastIndexOf(".");
        String extension = fileName.substring(lastDotIndex + 1);
    
        newName = name + "-" + date + "." + extension;
        return s3.getUrl(bucket, newName).toString();
    }
    
}
