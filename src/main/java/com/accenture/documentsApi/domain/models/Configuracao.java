package com.accenture.documentsApi.domain.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_configuracao")
public class Configuracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_configuracao")
    private Integer idConfiguracao;

    @Column(name = "tipo_dispositivo")
    private String tipoDispositivo;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "status")
    private String status;

    public Configuracao() {
    }

    public Configuracao(String tipoDispositivo, String tipoDocumento, String status) {
        this.tipoDispositivo = tipoDispositivo;
        this.tipoDocumento = tipoDocumento;
        this.status = status;
    }

    public Integer getIdConfiguracao() {
        return idConfiguracao;
    }

    public void setIdConfiguracao(Integer idConfiguracao) {
        this.idConfiguracao = idConfiguracao;
    }

    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(String tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
