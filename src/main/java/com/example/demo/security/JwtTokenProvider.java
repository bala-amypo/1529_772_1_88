package com.example.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String generateToken(String email, Long userId, String role) {
        return "dummy-token";
    }

    public String generateToken(Authentication authentication, Long userId, String role) {
        return "dummy-token";
    }

    public Long getUserIdFromToken(String token) {
        return 1L;
    }

    public String getEmailFromToken(String token) {
        return "test@example.com";
    }

    public String getRoleFromToken(String token) {
        return "RESIDENT";
    }

    public boolean validateToken(String token) {
        return true;
    }
}
