package com.accenture.documentsApi.dto;

public class ConfiguracaoDto {

    private String tipoDispositivo;
    private String tipoDocumento;
    private String status;

    public ConfiguracaoDto() {
    }

    public ConfiguracaoDto(String tipoDispositivo, String tipoDocumento, String status) {
        this.tipoDispositivo = tipoDispositivo;
        this.tipoDocumento = tipoDocumento;
        this.status = status;
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
