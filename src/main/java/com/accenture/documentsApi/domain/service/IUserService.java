package com.accenture.documentsApi.domain.service;

import com.accenture.documentsApi.domain.models.User;
import com.accenture.documentsApi.dto.UserDto;

import java.util.List;

public interface IUserService {

    List<User> buscarTodosUsuarios();
    User buscarUsuarioPorId(Integer id);
    String salvarUsuario(UserDto userDto);
    String atualizarUsuario(User user);
    String deletarUsuario(Integer idUser);
}
