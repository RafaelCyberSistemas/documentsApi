package com.accenture.documentsApi.domain.service;

import com.accenture.documentsApi.domain.models.Documento;
import com.accenture.documentsApi.dto.DocumentoDto;

import java.util.List;

public interface IDocumentoService {

    List<Documento> buscarTodosDocumentos();
    Documento buscarDocumentoPorId(Integer id);
    String salvarDocumento(DocumentoDto documentoDto);
    String atualizarDocumento(Documento documento);
    String deletarDocumento(Integer idDocumento);
}
