package com.accenture.documentsApi.domain.models;


import javax.persistence.*;

@Entity
@Table(name = "tb_palavra")
public class Palavra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_palavra")
    private Integer idPalavra;

    @Column(name = "palavra")
    private String palavra;

    @Column(name = "qtd_ocorrencias")
    private int quantidadeOcorrencias;

    @Column(name = "id_documento")
    private long idDocumento;

    public Palavra() {
    }

    public Palavra(String palavra, int quantidadeOcorrencias, long idDocumento) {
        this.palavra = palavra;
        this.quantidadeOcorrencias = quantidadeOcorrencias;
        this.idDocumento = idDocumento;
    }

    public Integer getIdPalavra() {
        return idPalavra;
    }

    public void setIdPalavra(Integer idPalavra) {
        this.idPalavra = idPalavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getQuantidadeOcorrencias() {
        return quantidadeOcorrencias;
    }

    public void setQuantidadeOcorrencias(int quantidadeOcorrencias) {
        this.quantidadeOcorrencias = quantidadeOcorrencias;
    }

    public long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(long idDocumento) {
        this.idDocumento = idDocumento;
    }
}
