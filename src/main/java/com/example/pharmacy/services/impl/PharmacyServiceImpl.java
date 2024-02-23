package com.example.pharmacy.services.impl;

import com.example.pharmacy.dto.request.PharmacyRequest;
import com.example.pharmacy.dto.response.PharmacyResponse;
import com.example.pharmacy.exception.NotFoundById;
import com.example.pharmacy.exception.NotFoundByName;
import com.example.pharmacy.mappers.PharmacyMapper;
import com.example.pharmacy.repositories.PharmacyRepository;
import com.example.pharmacy.services.repo.PharmacyService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PharmacyServiceImpl implements PharmacyService {
    private final PharmacyRepository pharmacyRepository;
    private final PharmacyMapper pharmacyMapper;

    @Override
    public List<PharmacyResponse> findAll() {
        return pharmacyMapper.toResponseList(pharmacyRepository.findAll());
    }

    @Override
    public PharmacyResponse findByName(String name) {
        return pharmacyMapper.toResponse( pharmacyRepository.findByName(name).orElseThrow(
                () -> new NotFoundByName("Not found pharmacy find this name : " + name)
                )

        );
    }

    @Override
    public PharmacyResponse findById(Long id) {
        return  pharmacyMapper.toResponse(pharmacyRepository.findById(id).orElseThrow(
                () -> new NotFoundById("Not found pharmacy by this id: " + id)
        ));
    }

    @Override
    public void save(PharmacyRequest pharmacyRequest) {
        pharmacyRepository.save(pharmacyMapper.toEntity(pharmacyRequest));
    }

    @Override
    public PharmacyResponse findByAddress(String address) {
        return  pharmacyMapper.toResponse(pharmacyRepository.findByAddress(address).orElseThrow(
                () -> new NotFoundById("Not found pharmacy by this address: " + address)
        ));
    }

}
