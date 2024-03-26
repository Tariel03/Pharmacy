package com.example.pharmacy.services.impl;

import com.example.pharmacy.dto.request.MedicineRequest;
import com.example.pharmacy.dto.response.MedicineResponse;
import com.example.pharmacy.entities.Medicine;
import com.example.pharmacy.exception.NotFoundById;
import com.example.pharmacy.mappers.MedicineMapper;
import com.example.pharmacy.repositories.MedicineRepository;
import com.example.pharmacy.services.repo.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {
    private final TypeServiceImpl typeService;
    private final MedicineRepository medicineRepository;
    private final MedicineMapper medicineMapper;
    @Override
    public List<MedicineResponse> findAll() {
        return medicineMapper.toResponseList(medicineRepository.findAll());
    }

    @Override
    public MedicineResponse findById(Long id) {
        return medicineMapper.toResponse(medicineRepository.findById(id).orElseThrow(
                () -> new NotFoundById("Not found medicine with id :" + id)
        ));
    }
    public Medicine findRawById(Long id) {
        return medicineRepository.findById(id).orElseThrow(
                () -> new NotFoundById("Not found medicine with id :" + id));
    }

    @Override
    public void save(MedicineRequest request) {
        medicineRepository.save(medicineMapper.toEntity(request));
    }

    @Override
    public void save(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    @Override
    public List<MedicineResponse> findByType(Long type_id) {
        return medicineMapper.toResponseList(
                medicineRepository.findByType(
                        typeService.findRawById(type_id)
                ));
    }

    @Override
    public void setType(Long type_id, Long id) {
        Medicine medicine = findRawById(id);
        medicine.setType(typeService.findRawById(type_id));
        save(medicineMapper.toRequest(medicine));
    }
}
