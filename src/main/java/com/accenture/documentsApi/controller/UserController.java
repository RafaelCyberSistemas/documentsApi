package com.accenture.documentsApi.controller;

import com.accenture.documentsApi.domain.models.User;
import com.accenture.documentsApi.domain.service.IUserService;
import com.accenture.documentsApi.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    IUserService userService;
    User usuario = new User();

    @GetMapping("/users")
    public List<User> buscarTodosUsuarios(){
        List<User> listaRetorno = new ArrayList<>();
        listaRetorno = userService.buscarTodosUsuarios();
        return listaRetorno;
    }

    @GetMapping("/user/{id}")
    public User buscarUsuarioPorId(@PathVariable int id){
        usuario = userService.buscarUsuarioPorId(id);
        return usuario;
    }

    @PostMapping("/user")
    public ResponseEntity salvarUsuario(@RequestBody UserDto dto){
        User user = new User(dto.getLogin(), dto.getPassword(), dto.getTipoUser());
        String body = userService.salvarUsuario(user);
        return ResponseEntity.status(201).body(body);
    }

    @PutMapping("/user")
    public ResponseEntity atualizarUsuario(@RequestBody User u){
        User user = new User(u.getIdUser(), u.getLogin(), u.getPassword(), u.getTipoUser());
        String body = userService.atualizarUsuario(user);
        return ResponseEntity.status(201).body(body);
    }

    @DeleteMapping("/user/{idUser}")
    public ResponseEntity deletarUsuario(@PathVariable int idUser){
        String body = userService.deletarUsuario(idUser);
        return ResponseEntity.status(201).body(body);
    }

}
