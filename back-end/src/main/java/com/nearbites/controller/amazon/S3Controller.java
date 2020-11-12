package com.nearbites.controller.amazon;

import com.nearbites.service.amazon.AmazonS3ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = { "http://localhost:8081" })
@RequestMapping("/storage")
public class S3Controller {

    private AmazonS3ImageService amazonS3ImageService;

    @Autowired
    S3Controller(AmazonS3ImageService amazonS3ImageService) {
        this.amazonS3ImageService = amazonS3ImageService;
    }

    @PostMapping("/uploadImage")
    public String uploadImage(MultipartFile file) {
        return this.amazonS3ImageService.uploadImageToAmazon(file);
    }

    @PostMapping("/uploadImages")
    public List<String> uploadImages(List<MultipartFile> files) {
        return this.amazonS3ImageService.insertImages(files);
    }
}
