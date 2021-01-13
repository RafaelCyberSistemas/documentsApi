package com.accenture.documentsApi.controller;

import com.accenture.documentsApi.domain.models.User;
import com.accenture.documentsApi.domain.service.IUserService;
import com.accenture.documentsApi.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/user")
    public List<User> buscarTodosUsuarios(){
        List<User> listaRetorno = new ArrayList<>();
        listaRetorno = userService.buscarTodosUsuarios();
        return listaRetorno;
    }

    @GetMapping("/user/{id}")
    public User buscarUsuarioPorId(@PathVariable int id){
        User usuario = new User();
        usuario = userService.buscarUsuarioPorId(id);
        return usuario;
    }

    @PostMapping("/user")
    public ResponseEntity salvarUsuario(@RequestBody @Valid UserDto dto){
        String body = userService.salvarUsuario(dto);
        return ResponseEntity.status(201).body(body);
    }

    @PutMapping("/user")
    public ResponseEntity atualizarUsuario(@RequestBody @Valid User user){
        String body = userService.atualizarUsuario(user);
        return ResponseEntity.status(201).body(body);
    }

    @DeleteMapping("/user/{idUser}")
    public void deletarUsuario(@PathVariable int idUser){
        userService.deletarUsuario(idUser);
    }

}
