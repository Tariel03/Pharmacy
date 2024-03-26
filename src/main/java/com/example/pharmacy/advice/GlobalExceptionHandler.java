package com.example.pharmacy.advice;

import com.example.pharmacy.exception.CloudStorageException;
import com.example.pharmacy.exception.NotFoundByAddress;
import com.example.pharmacy.exception.NotFoundById;
import com.example.pharmacy.exception.NotFoundByName;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NotFoundByAddress.class})
    public ResponseEntity<Object> handleNotFoundByAddress(NotFoundByAddress notFoundByAddress){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundByAddress.getMessage());
    }
    @ExceptionHandler({NotFoundById.class})
    public ResponseEntity<Object> handleNotFoundById(NotFoundById notFoundById){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(notFoundById.getMessage());
    }
    @ExceptionHandler({NotFoundByName.class})
    public ResponseEntity<Object> handleNotFoundByName(NotFoundByName notFoundByName){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundByName.getMessage());
    }
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<Object> handleMaxUploadSizeException(MaxUploadSizeExceededException ex) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("File too large!");
    }

    @ExceptionHandler(CloudStorageException.class)
    public ResponseEntity<Object> handle(CloudStorageException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cloud Storage Error");
    }

}
