package com.example.pharmacy.mappers;

import com.example.pharmacy.dto.request.TypeRequest;
import com.example.pharmacy.dto.response.TypeResponse;
import com.example.pharmacy.entities.Type;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeMapper {
    TypeMapper Instance = Mappers.getMapper(TypeMapper.class);
    List<TypeRequest> toListRequest(List<Type> list);
    List<TypeResponse> toListResponse(List<Type> list);

    Type type(TypeRequest typeRequest);
    Type type(TypeResponse typeResponse);
    TypeRequest toRequest(Type type);
    TypeResponse toResponse(Type type);
}
