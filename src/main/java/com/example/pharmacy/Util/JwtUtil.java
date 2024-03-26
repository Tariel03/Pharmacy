package com.example.pharmacy.Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JwtUtil {
    String secret = "tariel";
    int jwtExpirationMs = 100000000;
    int jwtRefreshExpirationMs = 1000000000;

    public String generateAccessToken(String username) {
        Date expirationDate = Date.from(ZonedDateTime.now().toInstant().plusMillis(jwtExpirationMs));
        return JWT.create()
                .withSubject("User details")
                .withClaim("username", username)
                .withIssuedAt(new Date())
                .withIssuer("Tariel")
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC256(secret));
    }
    public String generateRefreshToken(String username) {
        Date expirationDate = Date.from(ZonedDateTime.now().toInstant().plusMillis(jwtRefreshExpirationMs));
        return JWT.create()
                .withSubject("User details")
                .withClaim("username", username)
                .withIssuedAt(new Date())
                .withIssuer("Tariel")
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC256(secret));
    }


    public String validateTokenAndRetrieveClaim(String token) throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject("User details")
                .withIssuer("Tariel")
                .build();

        DecodedJWT jwt = verifier.verify(token);
        jwt.getSubject();
        return jwt.getClaim("username").asString();
    }
}