package com.accenture.documentsApi.domain.service;

import com.accenture.documentsApi.domain.models.User;

import java.util.List;

public interface IUserService {

    List<User> buscarTodosUsuarios();
    User buscarUsuarioPorId(Integer id);
    User salvarUsuario(User user);
    User atualizarUsuario(User user);
    void deletarUsuario(User user);
}
