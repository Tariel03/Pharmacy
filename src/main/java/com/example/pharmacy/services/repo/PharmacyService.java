package com.example.pharmacy.services.repo;

import com.example.pharmacy.dto.request.PharmacyRequest;
import com.example.pharmacy.dto.response.PharmacyResponse;

import java.util.List;

public interface PharmacyService {
    List<PharmacyResponse> findAll();
    PharmacyResponse findByName(String name);
    PharmacyResponse findById(Long id);
    void save(PharmacyRequest pharmacyRequest);
    PharmacyResponse findByAddress(String address);


}
