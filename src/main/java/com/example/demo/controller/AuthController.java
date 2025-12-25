package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.model.User;
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
    public ResponseEntity<LoginResponse> register(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        User savedUser = userService.register(user);

        String token = jwtTokenProvider.generateToken(
                savedUser.getUsername(),
                savedUser.getId(),
                savedUser.getRole()
        );

        return new ResponseEntity<>(
                new LoginResponse(
                        token,
                        savedUser.getId(),
                        savedUser.getUsername(),
                        savedUser.getRole()
                ),
                HttpStatus.CREATED
        );
    }
}
