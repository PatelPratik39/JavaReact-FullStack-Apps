package com.example.todoManagementApp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class TodoAPIException extends RuntimeException{
    private HttpStatus status;
    private String message;
}
