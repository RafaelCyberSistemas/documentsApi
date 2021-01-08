package com.accenture.documentsApi.controller;

import com.accenture.documentsApi.domain.models.Documento;
import com.accenture.documentsApi.domain.service.IDocumentoService;
import com.accenture.documentsApi.dto.DocumentoDto;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    public ResponseEntity salvarDocumento(@RequestBody DocumentoDto dto){
        String body = documentoService.salvarDocumento(dto);
        return ResponseEntity.status(201).body(body);
    }


    @PostMapping("/saveDoc")
    public Documento saveDoc(@RequestParam MultipartFile file){
        Documento documento = documentoService.saveDoc(file);
        return documento;
    }


    @PutMapping("/documento")
    public ResponseEntity atualizarDocumento(@RequestBody Documento documento){
        String body = documentoService.atualizarDocumento(documento);
        return ResponseEntity.status(201).body(body);
    }

    @DeleteMapping("/documento/{idDocumento}")
    public ResponseEntity deletarDocumento(@PathVariable Integer idDocumento){
        String body = documentoService.deletarDocumento(idDocumento);
        return ResponseEntity.status(201).body(body);
    }
}
