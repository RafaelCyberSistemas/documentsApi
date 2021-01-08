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

    @Column(name = "nome_arquivo")
    private String nomeArquivo;

    @Column(name = "tipo_arquivo")
    private String tipoArquivo;

    @Column(name = "tipo_dispositivo")
    private String tipoDispositivo;

    @Column(name = "quantidade_de_palavras")
    private int quantidadeDePalavras;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "data")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Documento() {
    }

    public Documento(String nomeArquivo, String tipoArquivo, String tipoDispositivo, int quantidadeDePalavras, User user) {
        this.nomeArquivo = nomeArquivo;
        this.tipoArquivo = tipoArquivo;
        this.tipoDispositivo = tipoDispositivo;
        this.quantidadeDePalavras = quantidadeDePalavras;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }
}
