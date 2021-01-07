package com.accenture.documentsApi.domain.service.serviceImplement;

import com.accenture.documentsApi.domain.models.User;
import com.accenture.documentsApi.domain.repository.IUserRepository;
import com.accenture.documentsApi.domain.service.IUserService;
import com.accenture.documentsApi.dto.UserDto;
import com.accenture.documentsApi.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> buscarTodosUsuarios() {
        return userRepository.findAll();
    }

    @Override
    public User buscarUsuarioPorId(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Usuário não localizado"));
    }

    @Override
    public String salvarUsuario(UserDto userDto) {
        User user = new User(userDto.getLogin(), userDto.getPassword(), userDto.getTipoUser());
        userRepository.save(user);
        String body = "Usuario: " + user.getLogin() + " tipo: " + user.getTipoUser() + " salvo com sucesso!!";
        return body;
    }

    @Override
    public String atualizarUsuario(User user) {
        userRepository.save(user);
        String body = "Usuario: " + user.getLogin() + " tipo: " + user.getTipoUser() + " atualizado com sucesso!";
        return body;
    }

    @Override
    public String deletarUsuario(Integer idUser) {
        User user = new User();
        user = buscarUsuarioPorId(idUser);
        userRepository.delete(user);
        String body = "Usuário removido com sucesso!!";
        return body;
    }
}
