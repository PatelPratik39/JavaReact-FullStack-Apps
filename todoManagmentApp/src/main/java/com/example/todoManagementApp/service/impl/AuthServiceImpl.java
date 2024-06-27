package com.example.todoManagementApp.service.impl;

import com.example.todoManagementApp.dto.LoginDto;
import com.example.todoManagementApp.dto.RegisterDto;
import com.example.todoManagementApp.entity.Role;
import com.example.todoManagementApp.entity.User;
import com.example.todoManagementApp.exception.TodoAPIException;
import com.example.todoManagementApp.repository.RoleRepository;
import com.example.todoManagementApp.repository.UserRepository;
import com.example.todoManagementApp.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authManager;

    @Override
    public String register ( RegisterDto registerDto ) {

//        check username exists or not
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST, "Username is already exists!");
        }

//        check email is already exist or not
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST,"Email is already Exists!!");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

//        after creating user we need to set a role for new user
        Set < Role > roles = new HashSet<>();
       Role userRole =  roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);
        userRepository.save(user);
        return "User registered Successfully!!";
    }

    @Override
    public String login ( LoginDto loginDto ) {

       Authentication authentication =  authManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "User registered Successfully!!";
    }


}
