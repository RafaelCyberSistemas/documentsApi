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
        String body;
        if(userRepository.existsById(user.getIdUser())){
            userRepository.save(user);
            body = "Usuario: " + user.getLogin() + " tipo: " + user.getTipoUser() + " atualizado com sucesso!";
            return body;
        }else{
            throw new NotFoundException("Não existe usuário com este ID: " + user.getIdUser() + " para ser atualizado");
        }
    }

    @Override
    public void deletarUsuario(Integer idUser) {
        if(userRepository.existsById(idUser)){
            userRepository.deleteById(idUser);
        }else{
            throw new NotFoundException("Não existe usuário cadastrado com este ID: " + idUser);
        }

    }
}
