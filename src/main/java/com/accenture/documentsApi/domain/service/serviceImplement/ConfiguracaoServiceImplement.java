package com.accenture.documentsApi.domain.service.serviceImplement;

import com.accenture.documentsApi.domain.models.Configuracao;
import com.accenture.documentsApi.domain.repository.IConfiguracaoRepository;
import com.accenture.documentsApi.domain.service.IConfiguracaoService;
import com.accenture.documentsApi.dto.ConfiguracaoDto;
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
    public String salvarConfiguracao(ConfiguracaoDto configuracaoDto) {
        Configuracao configuracao = new Configuracao(configuracaoDto.getTipoDispositivo(), configuracaoDto.getTipoDocumento(), configuracaoDto.getStatus());
        configuracaoRepository.save(configuracao);
        String body = "Configuração para dispositivo " + configuracao.getTipoDispositivo() + " tipo de Documento " + configuracao.getTipoDocumento() + " salva com sucesso!!";
        return body;
    }

    @Override
    public String atualizarConfiguracao(Configuracao configuracao) {
        configuracaoRepository.save(configuracao);
        String body = "Configuração atualizada com sucesso!!";
        return body;
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
