package com.example.pharmacy.controllers;


import com.example.pharmacy.Util.JwtUtil;
import com.example.pharmacy.dto.request.UserRequest;
import com.example.pharmacy.dto.response.TokenResponse;
import com.example.pharmacy.entities.AppUser;
import com.example.pharmacy.repositories.AppUserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import com.example.pharmacy.services.impl.*;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    AppUserRepository appUserRepository;
    AuthenticationManager authenticationManager;
    RegistrationServiceImpl registrationService;
    JwtUtil jwtUtil;
    UserServiceImpl userService;
    EmailService emailService;
    MessageSource messageSource;
    @PostMapping("/registration")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "http://correct-certain-quail.ngrok-free.app","https://correct-certain-quail.ngrok-free.app"})
//    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
    public ResponseEntity<?> performRegistration(@RequestBody UserRequest userRequest,  HttpServletRequest request) {
        String message  = "";
        //Проверяет нет ли такого человека уже
        if(userService.findByRawUsername(userRequest.getUsername()).isPresent()) {
            message = "User by this username exists";
            throw new BadCredentialsException(message);
        }
        registrationService.registration(userRequest,request);
        return ResponseEntity.ok("Email request send to your email. Please check it!");

    }

    @PostMapping("/login")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "http://correct-certain-quail.ngrok-free.app","https://correct-certain-quail.ngrok-free.app"})
    @Operation(summary = "Login", description = "This request is used for logging in")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserRequest.class)))) })
    public ResponseEntity< TokenResponse> performLogin(@RequestBody UserRequest authDto) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(authDto.getUsername(),
                        authDto.getPassword());
        String accessToken;
        String refreshToken;
        try {
            authenticationManager.authenticate(authInputToken);
            accessToken = jwtUtil.generateAccessToken(authDto.getUsername());
            refreshToken = jwtUtil.generateRefreshToken(authDto.getUsername());
        } catch (BadCredentialsException e) {
            accessToken = "Error";
            refreshToken = "Error";
        }

        TokenResponse tokenResponse =  TokenResponse.builder().accessToken(accessToken).refreshToken(refreshToken).build();
        //Если все норм то токен выдает!
        return ResponseEntity.ok(tokenResponse);
    }

    @PostMapping("/refresh")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "http://correct-certain-quail.ngrok-free.ap   p","https://correct-certain-quail.ngrok-free.app"})
    public ResponseEntity<Map<String,String>> refreshTokenResponse(String refreshToken){
        String accessToken = jwtUtil.generateAccessToken((jwtUtil.validateTokenAndRetrieveClaim(refreshToken)));
        return ResponseEntity.ok(Map.of("access-token",accessToken));
    }

    @GetMapping("/verify-email")
    public ResponseEntity<?> verifyEmail(@RequestParam("token") String token) {
        boolean isVerified = emailService.verifyEmail(token);
        if (isVerified) {
            // Retrieve user by token and update emailVerified field
            Optional<AppUser> optionalUser = userService.findByVerificationToken(token);
            if (optionalUser.isPresent()) {
                AppUser user = optionalUser.get();
                userService.save(user); // Update user's emailVerified field in the database
                String accessToken = jwtUtil.generateAccessToken(user.getUsername());
                String refreshToken = jwtUtil.generateRefreshToken(user.getUsername());

                TokenResponse tokenResponse =  TokenResponse.builder().accessToken(accessToken).refreshToken(refreshToken).build();
                emailService.deleteVerificationToken(token);
                return ResponseEntity.ok(tokenResponse);
             } else {
                return ResponseEntity.badRequest().body("User not found for token: " + token);
            }
        } else {
            return ResponseEntity.badRequest().body("Invalid or expired token.");
        }
    }






}
