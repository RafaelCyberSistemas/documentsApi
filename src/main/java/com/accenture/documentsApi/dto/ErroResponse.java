package com.accenture.documentsApi.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErroResponse {

    private String mensage;
    private String tipo;
}
