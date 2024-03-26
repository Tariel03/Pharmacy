package com.example.pharmacy.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserResponse {
    Long id;
    private String password;
    private String username;
    private String email;
    private String name;
}
