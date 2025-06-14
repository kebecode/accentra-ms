package com.kevinbedoya.accentra.infrastructure.web.advice;

import com.kevinbedoya.accentra.application.exception.PermissionDeniedException;
import com.kevinbedoya.accentra.domain.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle exceptions when a domain resource is not found.
     * Returns HTTP Status 404 (Not Found).
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException e) {
        Map<String, String> errorResponse = Map.of("error", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handle exceptions when a user does not have permissions.
     * Returns HTTP Status 403 (Forbidden).
     */
    @ExceptionHandler(PermissionDeniedException.class)
    public ResponseEntity<Map<String, String>> handlePermissionDeniedException(PermissionDeniedException e) {
        Map<String, String> errorResponse = Map.of("error", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }
    /**
     * Handle to "catch-all" unexpected exceptions.
     * Returns HTTP Status 500 (Internal Server Error).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception e) {
        Map<String, String> errorResponse = Map.of("error", "Unexpected error occurred in server");
        //log.error("Unhandled exception occurred", e);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
