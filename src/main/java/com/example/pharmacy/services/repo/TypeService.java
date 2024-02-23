package com.example.pharmacy.services.repo;

import com.example.pharmacy.dto.request.TypeRequest;
import com.example.pharmacy.dto.response.TypeResponse;

import java.util.List;

public interface TypeService {
    List<TypeResponse> findAll();
    void save(TypeRequest typeRequest);
    TypeResponse findById(Long id);
    TypeResponse findByName(String name);
}
