package com.accenture.documentsApi.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String erro){
        super(erro);
    }
}
