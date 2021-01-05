package com.accenture.documentsApi.domain.service;

import com.accenture.documentsApi.domain.models.User;

import java.util.List;

public interface IUserService {

    List<User> buscarTodosUsuarios();
    User buscarUsuarioPorId(Integer id);
    String salvarUsuario(User user);
    String atualizarUsuario(User user);
    String deletarUsuario(Integer idUser);
}
