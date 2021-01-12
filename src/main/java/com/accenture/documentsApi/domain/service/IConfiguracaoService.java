package com.accenture.documentsApi.domain.service;

import com.accenture.documentsApi.domain.models.Configuracao;
import com.accenture.documentsApi.dto.ConfiguracaoDto;

import java.util.List;

public interface IConfiguracaoService {

    List<Configuracao> buscarTodasConfiguracoes();
    Configuracao buscarConfiguracaoPorId(Integer id);
    String salvarConfiguracao(ConfiguracaoDto configuracaoDto);
    String atualizarConfiguracao(Configuracao configuracao);
    void deletarConfiguracao(Integer idConfiguracao);
}
