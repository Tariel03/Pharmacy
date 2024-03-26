package com.example.pharmacy.controllers;


import com.example.pharmacy.dto.response.ImageDTO;
import com.example.pharmacy.entities.Image;
import com.example.pharmacy.entities.Medicine;
import com.example.pharmacy.repositories.ImageRepository;
import com.example.pharmacy.services.impl.ImageServiceImpl;
import com.example.pharmacy.services.impl.MedicineServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImageServiceImpl imageService;
    private final MedicineServiceImpl medicineService;

    @PostMapping("/upload/{medicine_id}")
    public ResponseEntity<Map> uploadToMedicine(ImageDTO imageModel, @PathVariable Long medicine_id) {
            Image image = (Image) imageService.uploadImage(imageModel).getBody();
            Medicine medicine = medicineService.findRawById(medicine_id);
            medicine.setImage(image);
            medicineService.save(medicine);
            return ResponseEntity.ok(Map.of("url",medicine.getImage().getUrl()));
    }
}
