package com.example.pharmacy.services.repo;

import com.example.pharmacy.dto.response.ImageDTO;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ImageService {

    ResponseEntity<Map> uploadImage(ImageDTO imageModel);
}
