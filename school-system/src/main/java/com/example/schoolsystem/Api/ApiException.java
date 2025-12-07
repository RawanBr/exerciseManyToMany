package com.example.schoolsystem.Api;

public class ApiException extends RuntimeException{
    public ApiException (String message) {
        super(message);
    }
}
