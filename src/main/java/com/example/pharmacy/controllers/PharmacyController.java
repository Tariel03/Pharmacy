package com.example.pharmacy.controllers;

import com.example.pharmacy.dto.request.PharmacyRequest;
import com.example.pharmacy.dto.response.PharmacyResponse;
import com.example.pharmacy.services.impl.PharmacyServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pharmacy")
public class PharmacyController {
//
    private final PharmacyServiceImpl pharmacyService;
    @GetMapping("/all")
    public List<PharmacyResponse> findAll(){
        return pharmacyService.findAll();
    }
    @GetMapping("/{id}")
    public PharmacyResponse findById(@PathVariable("id") Long id){
        return pharmacyService.findById(id);
    }
    @GetMapping("/name")
    public PharmacyResponse findByName(@RequestParam("name") String name){
        return pharmacyService.findByName(name);
    }
    @GetMapping("/address")
    public PharmacyResponse findByAddress(@RequestParam("address") String address){
        return pharmacyService.findByAddress(address);
    }
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody PharmacyRequest pharmacyRequest){
        pharmacyService.save(pharmacyRequest);
        return ResponseEntity.ok("Success!");
    }

}
