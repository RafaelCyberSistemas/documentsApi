package com.accenture.documentsApi.domain.service.serviceImplement;

import com.accenture.documentsApi.domain.models.User;
import com.accenture.documentsApi.domain.repository.IUserRepository;
import com.accenture.documentsApi.domain.service.IUserService;
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
        return userRepository.findById(id).get();

    }

    @Override
    public User salvarUsuario(User user) {
        return userRepository.save(user);
    }

    @Override
    public User atualizarUsuario(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deletarUsuario(User user) {
        user = buscarUsuarioPorId(user.getIdUser());
        userRepository.delete(user);
    }
}
