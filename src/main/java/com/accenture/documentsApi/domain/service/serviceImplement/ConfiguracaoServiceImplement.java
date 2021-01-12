package com.accenture.documentsApi.domain.service.serviceImplement;

import com.accenture.documentsApi.domain.models.Configuracao;
import com.accenture.documentsApi.domain.repository.IConfiguracaoRepository;
import com.accenture.documentsApi.domain.service.IConfiguracaoService;
import com.accenture.documentsApi.dto.ConfiguracaoDto;
import com.accenture.documentsApi.exception.NotFoundException;
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
        return configuracaoRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Configuração não localizada por este ID"));
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
        String body;
        if(configuracaoRepository.existsById(configuracao.getIdConfiguracao())){
            configuracaoRepository.save(configuracao);
            body = "Configuração atualizada com sucesso!!";
            return body;
        }else{
            throw new NotFoundException("Não existe configuração com este ID: " + configuracao.getIdConfiguracao() + " para ser atualizada");
        }
    }

    @Override
    public void deletarConfiguracao(Integer idConfiguracao) {
        if(configuracaoRepository.existsById(idConfiguracao)){
            configuracaoRepository.deleteById(idConfiguracao);
        }else{
            throw new NotFoundException("Configuração não localizada para deletar");
        }
    }
}
