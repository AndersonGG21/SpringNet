package com.springnet.springnet.services;

import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Resource;

public interface StorageService {
    void init();

    String store(MultipartFile file);
    Resource loadAsResource(String fileName);

}
