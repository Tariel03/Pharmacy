package com.example.pharmacy.services.repo;

import com.example.pharmacy.dto.request.MedicineRequest;
import com.example.pharmacy.dto.response.MedicineResponse;
import com.example.pharmacy.entities.Medicine;

import java.util.List;

public interface MedicineService {
    List<MedicineResponse> findAll();
    MedicineResponse findById(Long id);

    void save(MedicineRequest request);
    void save(Medicine medicine);

    List<MedicineResponse> findByType(Long type_id);
    void setType(Long type_id, Long id);

}
