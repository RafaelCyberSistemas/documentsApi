package com.accenture.documentsApi.domain.service.serviceImplementTest;

import com.accenture.documentsApi.domain.models.Configuracao;
import com.accenture.documentsApi.domain.repository.IConfiguracaoRepository;
import com.accenture.documentsApi.domain.service.serviceImplement.ConfiguracaoServiceImplement;

import com.accenture.documentsApi.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
public class ConfiguracaoServiceImplementTest {

    @InjectMocks
    private ConfiguracaoServiceImplement configuracaoServiceImplement;

    @Mock
    private IConfiguracaoRepository configuracaoRepository;

    private Configuracao configuracao;

    @Before
    public void init(){
        configuracao = new Configuracao("MOBILE", ".TXT", "ATIVO");
        configuracao.setIdConfiguracao(1);
    }

    @Test
    public void buscarConfiguracaoPorIdComSucesso(){
        //cenario
        given(configuracaoRepository.findById(anyInt()))
                .willReturn(Optional.of(configuracao));
        //execução
        var result = configuracaoServiceImplement.buscarConfiguracaoPorId(anyInt());
        //validação
        assertNotNull(result);
        assertEquals(Optional.of(1), Optional.of(result.getIdConfiguracao()));
        verify(configuracaoRepository, times(1)).findById(anyInt());
    }

    @Test(expected = NotFoundException.class)
    public void buscarConfiguracaoPorIdQueNaoExiste(){
        //cenario
        given(configuracaoRepository.findById(anyInt()))
                .willReturn(Optional.empty());

        //execução
        var result = configuracaoServiceImplement.buscarConfiguracaoPorId(1);

        //validação
        verify(configuracaoRepository, times(1))
                .findById(anyInt());
    }

    @Test
    public void deletarConfiguracaoComSucesso(){
        //cenario
        given(configuracaoRepository.existsById(anyInt()))
                .willReturn(Boolean.TRUE);

        doNothing().when(configuracaoRepository).deleteById(anyInt());

        //execucao
        configuracaoServiceImplement.deletarConfiguracao(1);

        //validacao
        verify(configuracaoRepository, times(1))
                .existsById(anyInt());
        verify(configuracaoRepository, times(1))
                .deleteById(anyInt());
    }
    @Test(expected = NotFoundException.class)
    public void deletarConfiguracaoPorIdQueNaoExiste(){
        //cenario
        given(configuracaoRepository.existsById(anyInt()))
                .willReturn(Boolean.FALSE);
        doNothing().when(configuracaoRepository).deleteById(anyInt());
        //execucao
        configuracaoServiceImplement.deletarConfiguracao(1);
        //validacao
        verify(configuracaoRepository, times(1))
                .existsById(anyInt());
        verify(configuracaoRepository, times(1))
                .deleteById(anyInt());
    }
}
