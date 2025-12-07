package com.example.schoolsystem.Advice;

import com.example.schoolsystem.Api.ApiException;
import com.example.schoolsystem.Api.ApiResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    private final ResourcePatternResolver resourcePatternResolver;

    public ControllerAdvice(ResourcePatternResolver resourcePatternResolver) {
        this.resourcePatternResolver = resourcePatternResolver;
    }

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<?> ApiException (ApiException apiException) {
        String message = apiException.getMessage();

        return ResponseEntity.status(400).body(new ApiResponse(message));
    }


    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse>  MethodArgumentNotValidException (MethodArgumentNotValidException e) {
        String message = e.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(new ApiResponse(message));
    }


    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ApiResponse> ConstraintViolationException (ConstraintViolationException c) {
        return ResponseEntity.status(400).body(new ApiResponse(c.getMessage()));
    }


    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse> MethodArgumentTypeMismatchException (MethodArgumentTypeMismatchException c) {
        return ResponseEntity.status(400).body(new ApiResponse(c.getMessage()));
    }
}


