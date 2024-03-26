package com.example.pharmacy.services.repo;

import com.example.pharmacy.Enum.Role;
import com.example.pharmacy.dto.request.UserRequest;
import com.example.pharmacy.entities.AppUser;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<AppUser>findRawById(Long id);
    Optional<AppUser>findByVerificationToken(String token);
    UserRequest findById(Long id);
    List<UserRequest> findAll();
    Optional<UserRequest> findByUsername(String username);
    Optional<User> findByRawUsername(String username);

    Boolean existsByEmail(String email);

    void save(AppUser user);

    List<UserRequest>findByRole(Role role);
    int countVerifiedUsers();
}
