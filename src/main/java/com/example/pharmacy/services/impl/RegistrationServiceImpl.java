package com.example.pharmacy.services.impl;

import com.example.pharmacy.dto.request.UserRequest;
import com.example.pharmacy.entities.AppUser;
import com.example.pharmacy.repositories.AppUserRepository;
import com.example.pharmacy.services.repo.RegistrationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;


    public AppUser currentUser (){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails personDetails = (UserDetails) authentication.getPrincipal();
        String username =  personDetails.getUsername();
        Optional<AppUser> userOptional = appUserRepository.findByUsername(username);
        return userOptional.orElse(null);

    }





    @Transactional
    @Override
    public void registration(UserRequest userRequest, HttpServletRequest request){
        String pass = passwordEncoder.encode(userRequest.getPassword());
       userRequest.setPassword(pass);
       AppUser user = AppUser.builder().
               username(userRequest.getUsername()).
               email(userRequest.getEmail()).
               password(userRequest.getPassword()).
               name(userRequest.getName()).build();
        user.generateVerificationToken();

        appUserRepository.save(user);

        emailService.sendVerificationEmail(user.getEmail(), user.getEmailVerificationToken(), request);
    }


}
