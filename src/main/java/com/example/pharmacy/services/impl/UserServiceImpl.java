package com.example.pharmacy.services.impl;

import com.example.pharmacy.Enum.Role;
import com.example.pharmacy.dto.response.UserResponse;
import com.example.pharmacy.entities.AppUser;
import com.example.pharmacy.exception.NotFoundById;
import com.example.pharmacy.exception.NotFoundByName;
import com.example.pharmacy.mappers.AppUserMapper;
import com.example.pharmacy.repositories.AppUserRepository;
import com.example.pharmacy.services.repo.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AppUserRepository appUserRepository;
    private final AppUserMapper mapper;
    @Override
    public Optional<AppUser> findRawById(Long id) {
        return appUserRepository.findById(id);
    }

    @Override
    public Optional<AppUser> findByVerificationToken(String token) {
        return appUserRepository.findByEmailVerificationToken(token);
    }

    @Override
    public UserResponse findById(Long id) {
        return mapper.toResponse(appUserRepository.findById(id).orElseThrow(
                () -> new NotFoundById("Not found  with id :" + id)
        ));

    }

    @Override
    public List<UserResponse> findAll() {
        return mapper.toListResponse(appUserRepository.findAll());
    }

    @Override
    public UserResponse findByUsername(String username) {
        return mapper.toResponse(appUserRepository.findByUsername(username).orElseThrow(
                () -> new NotFoundByName("Not found with username : " + username)
        ));

    }
    public Optional<AppUser> findRawByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public Optional<AppUser> findByRawUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return appUserRepository.existsByEmail(email);
    }

    @Override
    public void save(AppUser user) {
        appUserRepository.save(user);
    }

    @Override
    public List<UserResponse> findByRole(Role role) {
        return mapper.toListResponse(appUserRepository.findByRole(role));
    }

    @Override
    public int countVerifiedUsers() {
        return appUserRepository.countByEmailVerifiedTrue();
    }
}
