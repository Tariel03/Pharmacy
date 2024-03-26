package com.example.pharmacy.services.impl;

import com.example.pharmacy.Enum.Role;
import com.example.pharmacy.dto.request.UserRequest;
import com.example.pharmacy.entities.AppUser;
import com.example.pharmacy.repositories.AppUserRepository;
import com.example.pharmacy.services.repo.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AppUserRepository appUserRepository;
    @Override
    public Optional<AppUser> findRawById(Long id) {
        return appUserRepository.findById(id);
    }

    @Override
    public Optional<AppUser> findByVerificationToken(String token) {
        return appUserRepository.findByEmailVerificationToken(token);
    }

    @Override
    public UserRequest findById(Long id) {
        return null;
    }

    @Override
    public List<UserRequest> findAll() {
        return null;
    }

    @Override
    public Optional<UserRequest> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByRawUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }

    @Override
    public void save(AppUser user) {
        appUserRepository.save(user);
    }

    @Override
    public List<UserRequest> findByRole(Role role) {
        return null;
    }

    @Override
    public int countVerifiedUsers() {
        return 0;
    }
}
