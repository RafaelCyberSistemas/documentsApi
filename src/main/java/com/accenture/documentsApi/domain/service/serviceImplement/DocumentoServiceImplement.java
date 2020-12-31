package com.accenture.documentsApi.domain.service.serviceImplement;

import com.accenture.documentsApi.domain.models.Documento;
import com.accenture.documentsApi.domain.repository.IDocumentoRepository;
import com.accenture.documentsApi.domain.service.IDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoServiceImplement implements IDocumentoService {

    @Autowired
    IDocumentoRepository documentoRepository;

    @Override
    public List<Documento> buscarTodosDocumentos() {
        return documentoRepository.findAll();
    }

    @Override
    public Documento buscarDocumentoPorId(Integer id) {
        return documentoRepository.findById(id).get();
    }

    @Override
    public Documento salvarDocumento(Documento documento) {
        return documentoRepository.save(documento);
    }

    @Override
    public Documento atualizarDocumento(Documento documento) {
        return documentoRepository.save(documento);
    }

    @Override
    public void deletarDocumento(Documento documento) {
        documento = buscarDocumentoPorId(documento.getIdDocumento());
        documentoRepository.delete(documento);
    }
}
