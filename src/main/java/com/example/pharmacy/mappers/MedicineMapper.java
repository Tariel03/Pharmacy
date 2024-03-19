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

    MedicineResponse toResponse(Medicine medicine);


    Medicine toEntity(MedicineRequest medicineRequest);


    List<MedicineResponse> toResponseList(List<Medicine> list);

    Set<MedicineResponse> toResponseSet(Set<Medicine> set);
}
