package com.example.pharmacy.services.repo;

import com.example.pharmacy.Enum.Role;
import com.example.pharmacy.dto.response.UserResponse;
import com.example.pharmacy.entities.AppUser;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<AppUser>findRawById(Long id);
    Optional<AppUser>findByVerificationToken(String token);
    UserResponse findById(Long id);

    List<UserResponse> findAll();
    UserResponse findByUsername(String username);
    Optional<AppUser> findByRawUsername(String username);

    Boolean existsByEmail(String email);

    void save(AppUser user);

    List<UserResponse>findByRole(Role role);
    int countVerifiedUsers();
}
