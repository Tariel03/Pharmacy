package com.example.pharmacy.services.repo;

import com.example.pharmacy.dto.request.UserRequest;
import com.example.pharmacy.entities.AppUser;

public interface AppUserService {
   AppUser findById(Long id);
   AppUser findByUsername(String username);
   AppUser findByEmail(String email);
   void save(UserRequest request);



}
