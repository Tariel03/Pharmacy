package com.example.pharmacy.repositories;

import com.example.pharmacy.Enum.Role;
import com.example.pharmacy.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmail(String email);
    AppUser findByEmailIgnoreCase(String emailId);

    Boolean existsByEmail(String email);
    int countByEmailVerifiedTrue();
    List<AppUser> findByRole(Role role);


    Optional<AppUser> findByEmailVerificationToken(String token);
    Boolean existsByEmailVerificationToken(String token);


}
