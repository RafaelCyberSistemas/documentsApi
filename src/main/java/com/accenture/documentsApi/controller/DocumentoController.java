package com.accenture.documentsApi.controller;

import com.accenture.documentsApi.domain.models.Documento;
import com.accenture.documentsApi.domain.service.IDocumentoService;
import com.accenture.documentsApi.domain.service.serviceImplement.DocumentoServiceImplement;
import com.accenture.documentsApi.dto.DocumentoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DocumentoController {

    @Autowired
    IDocumentoService documentoService;
    Documento doc = new Documento();

    @GetMapping("/documentos")
    public List<Documento> buscarTodosDocumentos(){
        List<Documento> listaRetorno = new ArrayList<>();
        listaRetorno = documentoService.buscarTodosDocumentos();
        return listaRetorno;
    }

    @GetMapping("/documento/{id}")
    public Documento buscarDocumentoPorId(@PathVariable int id){
        doc = documentoService.buscarDocumentoPorId(id);
        return doc;
    }

    @PostMapping("/documento")
    public ResponseEntity salvarDocumento(@RequestBody DocumentoDto dto){
        Documento documento = new Documento(dto.getTipoArquivo(), dto.getTipoDispositivo(), dto.getIdUser());
        String body = documentoService.salvarDocumento(documento);
        return ResponseEntity.status(201).body(body);
    }

    @PutMapping("/documento")
    public ResponseEntity atualizarDocumento(@RequestBody Documento doc){
        Documento documento = new Documento(doc.getIdDocumento(), doc.getTipoArquivo(), doc.getTipoDispositivo(), doc.getData(), doc.getIdUser());
        String body = documentoService.atualizarDocumento(documento);
        return ResponseEntity.status(201).body(body);
    }

    @DeleteMapping("/deletarDocumento/{idDocumento}")
    public ResponseEntity deletarDocumento(@PathVariable Integer idDocumento){
        String body = documentoService.deletarDocumento(idDocumento);
        return ResponseEntity.status(201).body(body);
    }
}
