package com.fullstack.employeeManagementbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/*
This the Exception class for resource not found,
this exception is extending of runtime Exception.
Also, I need to tell server that what exception occured with message so i need to provide annotaion with @ResponseStatus
that sends a status of the exception and message
 */



@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

        public  ResourceNotFoundException(String message){
            super(message);
        }
}


