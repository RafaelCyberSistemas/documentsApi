package com.accenture.documentsApi.dto;

import com.accenture.documentsApi.domain.models.Palavra;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentoDto {

    private String nomeArquivo;
    private String tipoArquivo;
    private String tipoDispositivo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date data;
    private int quantidadeDePalavras;
    private int idUser;

    public List<Palavra> listaDePalavras;

    public DocumentoDto() {
    }

    public DocumentoDto(String nomeArquivo, String tipoArquivo, String tipoDispositivo, int quantidadeDePalavras, int idUser) {
        this.nomeArquivo = nomeArquivo;
        this.tipoArquivo = tipoArquivo;
        this.tipoDispositivo = tipoDispositivo;
        this.quantidadeDePalavras = quantidadeDePalavras;
        this.idUser = idUser;
        listaDePalavras = new ArrayList<>();
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
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
