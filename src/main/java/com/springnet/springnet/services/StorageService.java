package com.springnet.springnet.services;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface StorageService {
    void init() throws IOException;

    String store(MultipartFile file);
    Resource loadAsResource(String fileName);

}
