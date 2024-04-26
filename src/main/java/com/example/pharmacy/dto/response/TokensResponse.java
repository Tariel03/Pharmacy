package com.example.pharmacy.dto.response;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class TokensResponse {
    private final String accessToken;
    private final String refreshToken;

    // Constructor with exactly the same parameters as fields
    private TokensResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
