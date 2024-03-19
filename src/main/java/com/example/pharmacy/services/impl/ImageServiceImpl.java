package com.example.pharmacy.services.impl;

import com.example.pharmacy.dto.response.ImageDTO;
import com.example.pharmacy.entities.Image;
import com.example.pharmacy.exception.CloudStorageException;
import com.example.pharmacy.repositories.ImageRepository;
import com.example.pharmacy.services.repo.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final CloudinaryServiceImpl cloudinaryService;
    private final ImageRepository imageRepository;


    @Override
    public ResponseEntity<Map> uploadImage(ImageDTO imageModel) {
        try {
            if (imageModel.getName().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            if (imageModel.getFile().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            Image image = new Image();
            image.setName(imageModel.getName());
            image.setUrl(cloudinaryService.uploadFile(imageModel.getFile(), "folder_1"));
            if (image.getUrl() == null) {
                return ResponseEntity.badRequest().build();
            }
            imageRepository.save(image);
            return ResponseEntity.ok().body(Map.of("url", image.getUrl()));
        } catch (CloudStorageException cloudStorageException) {
            cloudStorageException.printStackTrace();
        }
        return null;

    }

    }