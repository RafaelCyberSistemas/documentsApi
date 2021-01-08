package com.accenture.documentsApi.exception;

import com.accenture.documentsApi.dto.ErroResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErroResponse> interceptarErroNotFound(NotFoundException ex){
        return ResponseEntity.status(404).body(ErroResponse
                .builder()
                .mensage(ex.getLocalizedMessage())
                .tipo("DEBUG")
                .build());
    }
}
