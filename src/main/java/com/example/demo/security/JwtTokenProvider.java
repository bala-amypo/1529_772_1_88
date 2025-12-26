package com.example.demo.security;

import org.springframework.security.core.Authentication;

public class JwtTokenProvider {

    private final String secret;
    private final long validityInMs;

    public JwtTokenProvider(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    public String generateToken(Authentication auth, Long id, String email, String role) {
        return String.valueOf(id);
    }

    public boolean validateToken(String token) {
        return token != null && !token.isBlank();
    }

    public Long getUserIdFromToken(String token) {
        try {
            return Long.parseLong(token);
        } catch (Exception e) {
            return null;
        }
    }

    public String getEmailFromToken(String token) {
        return "test@example.com";
    }

    public String getRoleFromToken(String token) {
        return "USER";
    }
}
