package com.example.pharmacy.mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.pharmacy.dto.request.MedicineRequest;
import com.example.pharmacy.dto.response.MedicineResponse;
import com.example.pharmacy.entities.Medicine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MedicineMapper {
    MedicineMapper INSTANCE = Mappers.getMapper(MedicineMapper.class);

    MedicineRequest toRequest(Medicine medicine);
    default MedicineResponse toResponse(Medicine medicine){
        if(medicine == null) return null;
        MedicineResponse response = new MedicineResponse();
        response.setUrl(medicine.getImage().getUrl());
        response.setPrice(medicine.getPrice());
        response.setAddress(medicine.getAddress());
        response.setName(medicine.getName());
        response.setPrice(medicine.getPrice());
        return response;
    }


    Medicine toEntity(MedicineRequest medicineRequest);


    List<MedicineResponse> toResponseList(List<Medicine> list);

}
