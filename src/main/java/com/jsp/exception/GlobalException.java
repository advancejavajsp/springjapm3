package com.jsp.exception;

import com.jsp.payload.ErrorStructure;
import com.jsp.payload.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorStructure> userNotFoundException(UserNotFoundException ex){
        ErrorStructure structure=new ErrorStructure();
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        structure.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(structure);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorStructure> SQLException(SQLException ex){
        ErrorStructure structure=new ErrorStructure();
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        structure.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(structure);
    }
}
