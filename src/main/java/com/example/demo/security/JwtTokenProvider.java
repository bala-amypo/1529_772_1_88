package com.example.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public JwtTokenProvider() {}

    public String generateToken(String username, Long userId, String role) {
        return "dummy-token";
    }

    public String generateToken(Authentication authentication, Long userId, String role) {
        return "dummy-token";
    }
}
