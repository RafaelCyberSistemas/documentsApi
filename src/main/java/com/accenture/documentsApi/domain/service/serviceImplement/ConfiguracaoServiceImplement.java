package com.accenture.documentsApi.domain.service.serviceImplement;

import com.accenture.documentsApi.domain.models.Configuracao;
import com.accenture.documentsApi.domain.repository.IConfiguracaoRepository;
import com.accenture.documentsApi.domain.service.IConfiguracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiguracaoServiceImplement implements IConfiguracaoService {

    @Autowired
    IConfiguracaoRepository configuracaoRepository;

    @Override
    public List<Configuracao> buscarTodasConfiguracoes() {
        return configuracaoRepository.findAll();
    }

    @Override
    public Configuracao buscarConfiguracaoPorId(Integer id) {
        return configuracaoRepository.findById(id).get();
    }

    @Override
    public Configuracao salvarConfiguracao(Configuracao configuracao) {
        return configuracaoRepository.save(configuracao);
    }

    @Override
    public Configuracao atualizarConfiguracao(Configuracao configuracao) {
        return configuracaoRepository.save(configuracao);
    }

    @Override
    public String deletarConfiguracao(Integer idConfiguracao) {
        Configuracao configuracao = new Configuracao();
        configuracao = buscarConfiguracaoPorId(idConfiguracao);
        configuracaoRepository.delete(configuracao);
        String retorno = "Configuração removida com sucesso!";
        return  retorno;
    }
}
