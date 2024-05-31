package com.fullstack.todo.service;

import com.fullstack.todo.dto.LoginDTO;
import com.fullstack.todo.dto.RegisterDTO;

public interface AuthService {
    String register(RegisterDTO registerDTO);

    String login(LoginDTO loginDTO);
}
