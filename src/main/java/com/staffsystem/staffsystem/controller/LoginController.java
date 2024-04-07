package com.staffsystem.staffsystem.controller;

import com.staffsystem.staffsystem.model.login.LoginRetorno;
import com.staffsystem.staffsystem.model.login.LoginUsuario;
import com.staffsystem.staffsystem.repository.LoginUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {
    @Autowired
    LoginUsuarioRepository repository;
    @GetMapping("/usuarios")
    public ResponseEntity<List<LoginUsuario>> getUsuarios(){
        List<LoginUsuario> login = repository.findAll();

        if (login.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    @PostMapping("/usuarios")
    public ResponseEntity<?> getUsuarioByEmailAndSenha(@RequestBody LoginUsuario user) {
        LoginUsuario usuario = repository.findByEmailAndSenha(user.getEmail(), user.getSenha());

        if (usuario != null) {
            // Se o usuário for encontrado, retorna os detalhes do usuário em um JSON
            LoginRetorno retorno = new LoginRetorno(usuario.getNome(), usuario.getPermissao());
            return ResponseEntity.ok().body(retorno);
        } else {
            // Se o usuário não for encontrado, retorna um status 404
            return ResponseEntity.notFound().build();
        }
    }
}
