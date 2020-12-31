package com.accenture.documentsApi.domain.service;

import com.accenture.documentsApi.domain.models.Configuracao;

import java.util.List;

public interface IConfiguracaoService {

    List<Configuracao> buscarTodasConfiguracoes();
    Configuracao buscarConfiguracaoPorId(Integer id);
    Configuracao salvarConfiguracao(Configuracao configuracao);
    Configuracao atualizarConfiguracao(Configuracao configuracao);
    void deletarConfiguracao(Configuracao configuracao);

}
