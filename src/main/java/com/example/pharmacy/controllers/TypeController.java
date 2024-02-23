package com.example.pharmacy.controllers;

import com.example.pharmacy.dto.request.TypeRequest;
import com.example.pharmacy.dto.response.TypeResponse;
import com.example.pharmacy.services.repo.TypeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
@AllArgsConstructor
public class TypeController {
    private TypeService typeService;
    @GetMapping("/all")
    public List<TypeResponse> findAll(){
        return typeService.findAll();
    }
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody TypeRequest typeRequest){
        typeService.save(typeRequest);
        return ResponseEntity.ok("Success!");
    }
}
