package com.lvr.Build.a.bear.appconfiguration;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<String> handleEntityNotFound() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(DuplicateEntityException.class)
  public ResponseEntity<String> handleDuplicateEntity() {
    return ResponseEntity.badRequest().build();
  }
}
