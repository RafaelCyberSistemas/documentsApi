package com.accenture.documentsApi.domain.utils;

import com.accenture.documentsApi.domain.models.User;
import com.accenture.documentsApi.domain.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    IUserRepository userRepository;

    //@PostConstruct
    public void saveUser(){
        User user = new User("Login3", "123456", "Administrador");

        User userSaved = userRepository.save(user);
        System.out.println(userSaved.getIdUser());
    }

    @PostConstruct
    public void findAllUsers(){
        List<User> lista = new ArrayList<>();
        lista = userRepository.findAll();

        for (User user: lista) {
            System.out.println(user.getLogin() + " " + user.getTipoUser());
        }
    }

    //@PostConstruct
    public void findByIdUser(){
        User user = userRepository.findById(3).get();
        System.out.println(user.getLogin() + " " + user.getTipoUser());
    }

    //@PostConstruct
    public void deleteUser(){
        User user = userRepository.findById(3).get();
        userRepository.delete(user);
    }

}
