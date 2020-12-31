package com.accenture.documentsApi.domain.service;

import com.accenture.documentsApi.domain.models.Documento;
import com.accenture.documentsApi.domain.models.Palavra;

import java.util.List;

public interface IPalavraService {

    List<Palavra> buscarTodasPalavras();
    List<Palavra> buscarPalavrasPorIdDoDocumento(Integer id);
    Palavra buscarPalavraPorIdDaPalavra(Integer id);
    void salvarPalavras(List<Palavra> listaDePalavrasNoDocumento);
    void atualizarPalavras(List<Palavra> listaDePalavrasNoDocumento, Integer idDocumento);
    void deletarPalavras(Palavra palavra);
}
