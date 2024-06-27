package com.example.todoManagementApp.controller;

import com.example.todoManagementApp.dto.RegisterDto;
import com.example.todoManagementApp.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth/")
public class AuthController {

    private AuthService authService;

//    Build Register REST API

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto ){
        String response =  authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
