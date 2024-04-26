package com.example.pharmacy.services.repo;

import com.example.pharmacy.dto.request.UserRequest;
import com.example.pharmacy.entities.AppUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface RegistrationService {


    @Transactional
    void registration(UserRequest userRequest, HttpServletRequest request);

}
