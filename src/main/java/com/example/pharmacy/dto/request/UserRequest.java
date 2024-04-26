package com.example.pharmacy.dto.request;


import com.example.pharmacy.Enum.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@Setter
@Getter
@ToString
@Builder
public class UserRequest {
    private String password;
    private String username;
    private String email;
    private String name;
}
