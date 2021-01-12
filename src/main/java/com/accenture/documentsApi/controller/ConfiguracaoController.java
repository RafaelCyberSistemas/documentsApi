package com.accenture.documentsApi.controller;

import com.accenture.documentsApi.domain.models.Configuracao;
import com.accenture.documentsApi.domain.service.IConfiguracaoService;
import com.accenture.documentsApi.dto.ConfiguracaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ConfiguracaoController {

    @Autowired
    IConfiguracaoService configuracaoService;
    Configuracao config = new Configuracao();

    @GetMapping("/configuracoes")
    public List<Configuracao> buscarTodasConfiguracaoes(){
        List<Configuracao> listaRetorno = new ArrayList<>();
        listaRetorno = configuracaoService.buscarTodasConfiguracoes();
        return listaRetorno;
    }

    @GetMapping("/configuracao/{id}")
    public Configuracao buscarConfiguracaoPorId(@PathVariable int id){
        config = configuracaoService.buscarConfiguracaoPorId(id);
        return config;
    }

    @PostMapping("/configuracao")
    public ResponseEntity salvarConfiguracao(@RequestBody ConfiguracaoDto dto){
        String body = configuracaoService.salvarConfiguracao(dto);
        return ResponseEntity.status(201).body(body);
    }

    @PutMapping("/configuracao")
    public ResponseEntity atualizarConfiguracao(@RequestBody Configuracao configuracao){
        String body = configuracaoService.atualizarConfiguracao(configuracao);
        return ResponseEntity.status(201).body(body);
    }

    @DeleteMapping("/configuracao/{idConfiguracao}")
    public void deletarConfiguracao(@PathVariable int idConfiguracao){
        configuracaoService.deletarConfiguracao(idConfiguracao);
    }
}
