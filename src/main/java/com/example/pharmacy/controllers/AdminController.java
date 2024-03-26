package com.example.pharmacy.controllers;

import com.example.pharmacy.Enum.Role;
import com.example.pharmacy.entities.AppUser;
import com.example.pharmacy.services.impl.ImageServiceImpl;
import com.example.pharmacy.services.impl.UserServiceImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserServiceImpl userService;
    private final ImageServiceImpl imageService;

    @PostMapping("make/admin{id}")
    public ResponseEntity<?> makeAdmin(@PathVariable Long id){
        Optional<AppUser> optional = userService.findRawById(id);
        if(optional.isEmpty()){
            return ResponseEntity.badRequest().body("No user found by id :" + id);
        }
        AppUser user = optional.get();
        user.setRole(Role.ADMIN);
        userService.save(user);
        return  ResponseEntity.ok("Successfully added a new admin");
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello! I am admin!";
    }

}
