package com.accenture.documentsApi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import java.util.Date;

public class DocumentoDto {

    private String tipoArquivo;
    private String tipoDispositivo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date data;
    private int quantidadeDePalavras;
    private int idUser;

    public DocumentoDto() {
    }

    public DocumentoDto(String tipoArquivo, String tipoDispositivo, int quantidadeDePalavras, int idUser) {
        this.tipoArquivo = tipoArquivo;
        this.tipoDispositivo = tipoDispositivo;
        this.quantidadeDePalavras = quantidadeDePalavras;
        this.idUser = idUser;
    }

    public String getTipoArquivo() {
        return tipoArquivo;
    }

    public void setTipoArquivo(String tipoArquivo) {
        this.tipoArquivo = tipoArquivo;
    }

    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(String tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantidadeDePalavras() {
        return quantidadeDePalavras;
    }

    public void setQuantidadeDePalavras(int quantidadeDePalavras) {
        this.quantidadeDePalavras = quantidadeDePalavras;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
