package com.example.pharmacy.services.impl;

import com.example.pharmacy.entities.AppUser;
import com.example.pharmacy.repositories.AppUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmailService {
    @Value("${server.port}")
    String port = "";
    private  final JavaMailSender javaMailSender;
    private final AppUserRepository appUserRepository;
    public void sendVerificationEmail(String to, String verificationToken, HttpServletRequest request) {
        // Send email with verification link containing the token
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject("Email Verification");
        String htmlContent = "<p>Please click the following link to verify your email:</p>"
                + "<p><a href=\"http://" + request.getServerName() + ":" + port
                + "/auth/verify-email?token=" + verificationToken + "\">Verify Email</a></p>";
        message.setText(htmlContent); // Set the content as HTML
        javaMailSender.send(message);

    }

    public boolean verifyEmail(String token) {
        // Retrieve user by the token (assuming you have a repository for users)
        Optional<AppUser> optionalUser = appUserRepository.findByEmailVerificationToken(token);

        if (optionalUser.isPresent()) {
            AppUser user = optionalUser.get();

            // Check if the token is expired
            if (isTokenExpired(user.getVerificationTokenExpiration())) {
                // Token expired, handle accordingly (delete token, prompt user to resend verification)
                // For example: deleteVerificationToken(user);
                return false;
            }

            // If token is valid, update user's emailVerified field and save user
            user.setEmailVerified(true);
            appUserRepository.save(user);

            // Optionally, delete the verification token after successful verification
            // For example: deleteVerificationToken(user);

            return true; // Email successfully verified
        }

        return false; // Token not found or invalid
    }
    public void deleteVerificationToken(String token){
        Optional<AppUser> optionalUser = appUserRepository.findByEmailVerificationToken(token);
        if (optionalUser.isPresent()) {
            AppUser user = optionalUser.get();
            user.setVerificationTokenExpiration(
                    null
            );
            user.setEmailVerificationToken(null);
            appUserRepository.save(user);
        }
    }

    private boolean isTokenExpired(Date expirationDate) {
        return expirationDate != null && expirationDate.before(new Date());

    }

}
