package com.nearbites.service.amazon;

import com.amazonaws.services.rekognition.model.InvalidImageFormatException;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.nearbites.util.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AmazonS3ImageService extends AmazonClient {

    public List<String> insertImages(List<MultipartFile> images) {
        List<String> urls = new ArrayList<>();
        for (MultipartFile image : images) {
            urls.add(uploadImageToAmazon(image));
        }
        return urls;
    }

    public String uploadImageToAmazon(MultipartFile multipartFile) {
        List<String> validExtensions = Arrays.asList("jpeg","jpg", "png");

        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        if (!validExtensions.contains(extension)) {
            throw new InvalidImageFormatException(extension);
        }
        else {
            return uploadMultipartFile(multipartFile);
        }
    }

    private String uploadMultipartFile(MultipartFile multipartFile) {
        String fileUrl = null;

        try {
            File file = FileUtils.convertMultipartToFile(multipartFile);

            String fileName = FileUtils.generateFileName(multipartFile);

            getClient().putObject(new PutObjectRequest(getBucketName(), fileName, file)
                    .withCannedAcl(CannedAccessControlList.PublicRead));

            file.delete();
            fileUrl = getUrl().concat(fileName);
        } catch (IOException e) {
            System.err.println(e);
        }

        return fileUrl;
    }
}