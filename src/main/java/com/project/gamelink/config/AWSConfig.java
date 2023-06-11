package com.project.gamelink.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import com.amazonaws.auth.*;
import com.amazonaws.services.s3.*;

@Configuration
public class AWSConfig {

    @Value("${aws.access}")
    private String accessKey;

    @Value("${aws.secret}")
    private String secretKey;

    @Value("${aws.region}")
    private String region;

    @Bean
    public AmazonS3 bucket(){
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        return AmazonS3ClientBuilder.standard().withRegion(region).withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
    }

}