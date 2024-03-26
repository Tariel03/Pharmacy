package com.example.pharmacy.security;

import com.example.pharmacy.entities.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
public class AppUserDetails implements UserDetails {
    private final AppUser appUser;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(appUser.getRole().toString()));
    }

    @Override
    public String getPassword() {
        return this.appUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.appUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return appUser.isEmailVerified();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return appUser.isEmailVerified();
    }
}
