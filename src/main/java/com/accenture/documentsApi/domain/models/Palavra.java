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

    @ManyToOne
    @JoinColumn(name = "id_documento")
    Documento documento;

    public Palavra() {
    }

    public Palavra(String palavra) {
        this.palavra = palavra;
        this.quantidadeOcorrencias = 0;
        this.documento = new Documento();
    }

    public Palavra(String palavra, int quantidadeOcorrencias, Documento documento) {
        this.palavra = palavra;
        this.quantidadeOcorrencias = quantidadeOcorrencias;
        this.documento = documento;
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

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
}
