package com.accenture.documentsApi.domain.service;

import com.accenture.documentsApi.domain.models.Documento;
import com.accenture.documentsApi.dto.DocumentoDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IDocumentoService {

    List<Documento> buscarTodosDocumentos();
    Documento buscarDocumentoPorId(Integer id);
    Documento salvarDocumento(MultipartFile file);
    String atualizarDocumento(Documento documento);
    void deletarDocumento(Integer idDocumento);
}
