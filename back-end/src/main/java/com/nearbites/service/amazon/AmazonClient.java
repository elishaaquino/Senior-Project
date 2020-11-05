package com.nearbites.service.amazon;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AmazonClient {

    private AmazonS3 amazonS3;

    @Value("${amazon.s3.endpoint}")
    private String endpoint;

    @Value("${amazon.s3.bucket-name}")
    private String bucketname;

    @Value("${amazon.s3.access-key}")
    private String accessKey;

    @Value("${amazon.s3.secret-key}")
    private String secretKey;

    protected AmazonS3 getClient() {
        return amazonS3;
    }

    protected String getBucketName() {
        return bucketname;
    }

    protected String getUrl() {
        return endpoint;
    }

    @PostConstruct
    private void init() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
        this.amazonS3 = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_WEST_1)
                .withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
    }
}
