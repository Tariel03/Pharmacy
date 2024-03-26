package com.example.pharmacy.security;

import com.example.pharmacy.entities.AppUser;
import com.example.pharmacy.repositories.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {
    private final AppUserRepository appUserRepository;
    private final String USER_NOT_FOUND = "user with email %s not found";
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser>optional = appUserRepository.findByUsername(username);
        if(optional.isEmpty()){
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND, username));
        }
        return new AppUserDetails(optional.get());
    }
}
