package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.model.UserEntity;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService,
                          JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {

        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        UserEntity savedUser = userService.register(user);

        String token = jwtTokenProvider.generateToken(
                savedUser.getEmail(),
                savedUser.getId(),
                savedUser.getRole()
        );

        return new ResponseEntity<>(
                new AuthResponse(
                        token,
                        savedUser.getId(),
                        savedUser.getEmail(),
                        savedUser.getRole()
                ),
                HttpStatus.CREATED
        );
    }
}
