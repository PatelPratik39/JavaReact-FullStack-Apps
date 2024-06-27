package com.example.todoManagementApp.service;

import com.example.todoManagementApp.dto.LoginDto;
import com.example.todoManagementApp.dto.RegisterDto;

public interface AuthService {

    String register( RegisterDto registerDto );
    String login( LoginDto loginDto );
}
