package com.example.pharmacy.controllers;

import com.example.pharmacy.dto.request.MedicineRequest;
import com.example.pharmacy.dto.response.MedicineResponse;
import com.example.pharmacy.services.impl.MedicineServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/medicine")
public class MedicineController  {
    private final MedicineServiceImpl medicineService;
    @GetMapping("/all")
    public List<MedicineResponse> findAll(){
        return medicineService.findAll();
    }
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody MedicineRequest medicineRequest){
        medicineService.save(medicineRequest);
        return ResponseEntity.ok("Success!");
    }
    @GetMapping("/{id}")
    public MedicineResponse findById(@PathVariable("id")Long id ){
        return medicineService.findById(id);
    }
    @GetMapping("/type")
    public List<MedicineResponse> findAllByType(@RequestParam("type_id") Long type_id){
        return medicineService.findByType(type_id);
    }



}
