package com.example.pharmacy.controllers;


import com.example.pharmacy.dto.response.ImageDTO;
import com.example.pharmacy.repositories.ImageRepository;
import com.example.pharmacy.services.impl.ImageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageServiceImpl imageService;

    @PostMapping("/upload")
    public ResponseEntity<Map> upload(ImageDTO imageModel) {
            return imageService.uploadImage(imageModel);
    }
}
