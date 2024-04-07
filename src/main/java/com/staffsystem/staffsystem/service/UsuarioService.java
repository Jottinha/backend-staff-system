package com.staffsystem.staffsystem.service;

import com.staffsystem.staffsystem.model.login.LoginUsuario;
import com.staffsystem.staffsystem.repository.LoginUsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private LoginUsuarioRepository service;

    public UsuarioService(LoginUsuarioRepository service) {
        this.service = service;
    }

    public LoginUsuario getUsuarioByName(String name){
        LoginUsuario usuario = service.findByNome(name);

        return usuario;
    }
}
