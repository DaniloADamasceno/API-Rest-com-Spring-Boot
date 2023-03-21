package com.modulo24.resources.exceptions;

import com.modulo24.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice // --> Anotação para interceptar as exceções
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException objectNotFoundException, HttpServletRequest request) {
        String errorDescription = "⚠️RESOURCE NOT FOUND ⚠️/⚠️ RECURSO NÂO ENCONTRADO ⚠️";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;  // ---> 404 - Not Found (Não encontrado)
        StandardError standardeError = new StandardError(Instant.now(), httpStatus.value(), errorDescription, objectNotFoundException.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardeError);
    }
}
