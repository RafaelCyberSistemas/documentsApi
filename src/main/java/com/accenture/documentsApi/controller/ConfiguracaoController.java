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
        Configuracao configuracao = new Configuracao(dto.getTipoDispositivo(), dto.getTipoDocumento(), dto.getStatus());
        config = configuracaoService.salvarConfiguracao(configuracao);
        String body = "Tipo Dispositivo " + config.getTipoDispositivo() + " tipo de Documento " + config.getTipoDocumento() +" Salvo com sucesso";
        return ResponseEntity.status(201).body(body);
    }

    @PutMapping("/configuracao")
    public Configuracao atualizarConfiguracao(@RequestBody Configuracao configuracao){
        config = configuracaoService.atualizarConfiguracao(configuracao);
        return config;
    }

    @DeleteMapping("/configuracao/{idConfiguracao}")
    public ResponseEntity deletarConfiguracao(@PathVariable int idConfiguracao){
        String body = configuracaoService.deletarConfiguracao(idConfiguracao);
        return ResponseEntity.status(201).body(body);
    }
}
