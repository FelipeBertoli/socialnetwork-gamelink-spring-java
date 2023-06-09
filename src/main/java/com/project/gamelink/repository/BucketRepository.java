package com.project.gamelink.repository;

import org.springframework.web.multipart.MultipartFile;

public interface BucketRepository {

    String saveFile(MultipartFile file, String name, String date);

    byte[] downloadFile(String fileName);

    String getUrl(MultipartFile file, String name, String date);

    
}
