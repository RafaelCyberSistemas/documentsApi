package com.accenture.documentsApi.controller;

import com.accenture.documentsApi.domain.models.Documento;
import com.accenture.documentsApi.domain.service.IDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DocumentoController {

    @Autowired
    IDocumentoService documentoService;

    @GetMapping("/documentos")
    public List<Documento> buscarTodosDocumentos(){
        List<Documento> listaRetorno = new ArrayList<>();
        listaRetorno = documentoService.buscarTodosDocumentos();
        return listaRetorno;
    }

    @GetMapping("/documento/{id}")
    public Documento buscarDocumentoPorId(@PathVariable int id){
        Documento doc = new Documento();
        doc = documentoService.buscarDocumentoPorId(id);
        return doc;
    }


    @PostMapping("/documento")
    public Documento salvarDocumento(@RequestParam MultipartFile file){
        Documento documento = documentoService.salvarDocumento(file);
        return documento;
    }


    @PutMapping("/documento")
    public ResponseEntity atualizarDocumento(@RequestBody Documento documento){
        String body = documentoService.atualizarDocumento(documento);
        return ResponseEntity.status(201).body(body);
    }

    @DeleteMapping("/documento/{idDocumento}")
    public void deletarDocumento(@PathVariable Integer idDocumento){
        documentoService.deletarDocumento(idDocumento);
    }
}
