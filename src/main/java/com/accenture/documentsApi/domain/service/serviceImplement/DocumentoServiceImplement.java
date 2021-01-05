package com.accenture.documentsApi.domain.service.serviceImplement;

import com.accenture.documentsApi.domain.models.Documento;
import com.accenture.documentsApi.domain.repository.IDocumentoRepository;
import com.accenture.documentsApi.domain.service.IDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DocumentoServiceImplement implements IDocumentoService {

    @Autowired
    IDocumentoRepository documentoRepository;
    Documento documento = new Documento();

    @Override
    public List<Documento> buscarTodosDocumentos() {
        return documentoRepository.findAll();
    }

    @Override
    public Documento buscarDocumentoPorId(Integer id) {
        return documentoRepository.findById(id).get();
    }

    @Override
    public String salvarDocumento(Documento documento) {
        Date date = new Date();
        documento.setData(date);
        documentoRepository.save(documento);
        String body = "Documento salvo com sucesso!!!";
        return body;
    }

    @Override
    public String atualizarDocumento(Documento documento) {
        //documentoRepository.save(documento);
        String body = "Documento atualizado com sucesso!!";
        return body;
    }

    @Override
    public String deletarDocumento(Integer idDocumento) {
        documento = buscarDocumentoPorId(idDocumento);
        documentoRepository.delete(documento);
        String body = "Documento removido com sucesso!!";
        return body;
    }
}
