package com.accenture.documentsApi.domain.service.serviceImplementTest;


import com.accenture.documentsApi.domain.models.User;
import com.accenture.documentsApi.domain.repository.IUserRepository;
import com.accenture.documentsApi.domain.service.serviceImplement.UserServiceImplement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.accenture.documentsApi.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserServiceImplementTest {

    @InjectMocks
    private UserServiceImplement userServiceImplement;

    @Mock
    private IUserRepository userRepository;

    private User user;

    @Before
    public void init(){
        this.user = new User(1,"Login", "123456", "Administrador");
    }

    @Test
    public void buscarUserPorIdComSucesso(){
        //cenario
        given(userRepository.findById(anyInt()))
                .willReturn(Optional.of(user));
        //execução
        var result = userServiceImplement.buscarUsuarioPorId(anyInt());

        //validação
        assertNotNull(result);
        assertEquals(Optional.of(1), Optional.of(result.getIdUser()));
        verify(userRepository, times(1)).findById(anyInt());
    }

    @Test(expected = NotFoundException.class)
    public void buscarUserPorIdQueNaoExiste(){
        //cenario
        given(userRepository.findById(anyInt()))
                .willReturn(Optional.empty());

        //execucao
        var result = userServiceImplement.buscarUsuarioPorId(1);

        //validacao
        verify(userRepository, times(1))
                .findById(anyInt());
    }
    
    @Test
    public void deletarUserPorIdComSucesso(){
        //cenario
        given(userRepository.existsById(anyInt()))
                .willReturn(Boolean.TRUE);

        doNothing().when(userRepository).deleteById(anyInt());

        //execucao
        userServiceImplement.deletarUsuario(1);

        //validacao
        verify(userRepository, times(1))
                .existsById(anyInt());
        verify(userRepository, times(1))
                .deleteById(anyInt());

    }

    @Test(expected = NotFoundException.class)
    public void deletarUserPorIdQueNaoExiste(){
        //cenario
        given(userRepository.existsById(anyInt()))
                .willReturn(Boolean.FALSE);

        doNothing().when(userRepository).deleteById(anyInt());

        //excucao
        userServiceImplement.deletarUsuario(1);

        //validacao
        verify(userRepository, times(1))
                .existsById(1);
        verify(userRepository, times(1))
                .deleteById(anyInt());

    }
}
