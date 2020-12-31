package com.accenture.documentsApi.domain.service;

import com.accenture.documentsApi.domain.models.Documento;

import java.util.List;

public interface IDocumentoService {

    List<Documento> buscarTodosDocumentos();
    Documento buscarDocumentoPorId(Integer id);
    Documento salvarDocumento(Documento documento);
    Documento atualizarDocumento(Documento documento);
    void deletarDocumento(Documento documento);
}
