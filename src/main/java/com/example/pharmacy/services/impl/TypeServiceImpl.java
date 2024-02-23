package com.example.pharmacy.services.impl;

import com.example.pharmacy.dto.request.TypeRequest;
import com.example.pharmacy.dto.response.TypeResponse;
import com.example.pharmacy.entities.Type;
import com.example.pharmacy.exception.NotFoundById;
import com.example.pharmacy.exception.NotFoundByName;

import com.example.pharmacy.mappers.TypeMapper;
import com.example.pharmacy.repositories.TypeRepository;
import com.example.pharmacy.services.repo.TypeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;
    private final TypeMapper mapper;
    @Override
    public List<TypeResponse> findAll() {
        return mapper.toListResponse(typeRepository.findAll());
    }

    @Override
    public void save(TypeRequest typeRequest) {
        Type type = Type.builder().type(typeRequest.getType()).build();
        typeRepository.save(type);
    }

    @Override
    public TypeResponse findById(Long id) {
        return mapper.toResponse(typeRepository.findById(id).orElseThrow(
                () -> new NotFoundById("Not found type with id : " + "id")));
    }
    public Type findRawById(Long id) {
        return typeRepository.findById(id).orElseThrow(
                () -> new NotFoundById("Not found type with id : " + "id"));
    }

    @Override
    public TypeResponse findByName(String name) {
        return mapper.toResponse(typeRepository.findByType(name).orElseThrow(
                () -> new NotFoundByName("Not found type with this name : " + name)
        ));
    }

}
