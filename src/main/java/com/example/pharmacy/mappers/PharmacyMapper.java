package com.example.pharmacy.mappers;

import com.example.pharmacy.dto.request.PharmacyRequest;
import com.example.pharmacy.dto.response.MedicineResponse;
import com.example.pharmacy.dto.response.PharmacyResponse;
import com.example.pharmacy.entities.Medicine;
import com.example.pharmacy.entities.Pharmacy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")

public interface PharmacyMapper  {
    PharmacyMapper Instance = Mappers.getMapper(PharmacyMapper.class);


    PharmacyResponse toResponse(Pharmacy pharmacy);

    PharmacyRequest toRequest(Pharmacy pharmacy);
    Pharmacy toEntity(PharmacyResponse response);

    Pharmacy toEntity(PharmacyRequest request);
    List<PharmacyResponse> toResponseList(List<Pharmacy> list);




}
