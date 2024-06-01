package com.fullstack.todo.service.impl;

import com.fullstack.todo.dto.LoginDTO;
import com.fullstack.todo.dto.RegisterDTO;
import com.fullstack.todo.entity.Role;
import com.fullstack.todo.entity.User;
import com.fullstack.todo.exceptions.TodoAPIException;
import com.fullstack.todo.repository.RoleRepository;
import com.fullstack.todo.repository.UserRepository;
import com.fullstack.todo.service.AuthService;
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
    private AuthenticationManager authenticationManager;

    @Override
    public String register(RegisterDTO registerDTO) {

//        checking that username is already present in a database
        if(userRepository.existsByUsername(registerDTO.getUsername())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST,  "Username already exists!!");
        }

//        Check email is already present in a database
        if(userRepository.existsByEmail(registerDTO.getEmail())){
            throw new TodoAPIException(HttpStatus.BAD_REQUEST, "Email is already Exists!!!");
        }

//        User Jpa Object
        User user = new User();
        user.setName(registerDTO.getName());
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);
        userRepository.save(user);

        return "User Registered Successfully!!!";
    }

    @Override
    public String login(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDTO.getUsernameOrEmail(),
                loginDTO.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "User Logged-In Successfully!!!";
    }
}
