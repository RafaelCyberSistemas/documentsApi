package com.accenture.documentsApi.domain.service.serviceImplementTest;


import com.accenture.documentsApi.domain.models.Documento;
import com.accenture.documentsApi.domain.models.User;
import com.accenture.documentsApi.domain.repository.IDocumentoRepository;
import com.accenture.documentsApi.domain.service.serviceImplement.DocumentoServiceImplement;
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
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class DocumentoServiceImplementTest {

    @InjectMocks
    private DocumentoServiceImplement documentoServiceImplement;

    @Mock
    private IDocumentoRepository documentoRepository;

    private Documento documento;
    private User user;

    @Before
    public void init(){
        user = new User(1);
        documento = new Documento("nome do arquivo", "PDF", "MOBILE", 100, user);
        documento.setIdDocumento(1);
    }
    @Test
    public void buscarDocumentoPorIdComSucesso(){
        //cenario
        given(documentoRepository.findById(anyInt()))
                .willReturn(Optional.of(documento));
        //execucao
        var result = documentoServiceImplement.buscarDocumentoPorId(1);

        //validacao
        assertNotNull(result);
        assertEquals(Optional.of(1), Optional.of(result.getIdDocumento()));
        verify(documentoRepository, times(1)).findById(anyInt());
    }
    @Test(expected = NotFoundException.class)
    public void buscarDocumentoPorIdQueNaoExiste(){
        //cenario
        given(documentoRepository.findById(anyInt()))
                .willReturn(Optional.empty());
        //execucao
        var result = documentoServiceImplement.buscarDocumentoPorId(anyInt());

        //validacao
        verify(documentoRepository, times(1))
                .findById(anyInt());
    }
}
