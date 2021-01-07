package com.accenture.documentsApi.domain.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_documento")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento")
    private Integer idDocumento;

    @Column(name = "tipo_arquivo")
    private String tipoArquivo;

    @Column(name = "tipo_dispositivo")
    private String tipoDispositivo;

    @Column(name = "quantidade_de_palavras")
    private int quantidadeDePalavras;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "data")
    private Date data;

    @Column(name = "id_user")
    private int idUser;

    public Documento() {
    }

    public Documento(String tipoArquivo, String tipoDispositivo, int quantidadeDePalavras, int idUser) {
        this.tipoArquivo = tipoArquivo;
        this.tipoDispositivo = tipoDispositivo;
        this.quantidadeDePalavras = quantidadeDePalavras;
        this.idUser = idUser;
    }

    public Documento(Integer idDocumento, String tipoArquivo, String tipoDispositivo, int quantidadeDePalavras, Date data, int idUser) {
        this.idDocumento = idDocumento;
        this.tipoArquivo = tipoArquivo;
        this.tipoDispositivo = tipoDispositivo;
        this.quantidadeDePalavras = quantidadeDePalavras;
        this.data = data;
        this.idUser = idUser;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
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
