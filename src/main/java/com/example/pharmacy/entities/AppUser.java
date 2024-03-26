package com.example.pharmacy.entities;

import com.example.pharmacy.Enum.Role;
import com.example.pharmacy.entities.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapper;

import java.time.LocalDate;
import java.util.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Table(name = "tb_user")

public class AppUser extends BaseEntity {
    @Id
    private Long id;
    @Column(name = "password")
    private String password;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    Role role;
    @Column(name = "email_verification_token")
    private String emailVerificationToken;

    @Column(name = "verification_token_expiration")
    @Temporal(TemporalType.TIMESTAMP)
    private Date verificationTokenExpiration;

    @Column(name = "email_verified")
    private boolean emailVerified;

    @JoinColumn(name = "image_id")
    @ManyToOne
    Image image;

    public AppUser(String password, String username, String email, String name) {
        this.password = password;
        this.username = username;
        this.email = email;
        this.name = name;
        role = Role.USER;
    }

    public AppUser(String password, String username, String email, String name, Role role) {
        this.password = password;
        this.username = username;
        this.email = email;
        this.name = name;
        this.role = role;
    }
    @PostPersist()
    public void prePersist(){
        role = Role.USER;
    }

    public void generateVerificationToken() {
        this.emailVerificationToken = generateRandomToken();
        // Set token expiration to 24 hours from current time
        this.verificationTokenExpiration = new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000));
    }

    private String generateRandomToken() {
        return UUID.randomUUID().toString();
    }


}
