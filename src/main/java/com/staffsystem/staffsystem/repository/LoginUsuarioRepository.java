package com.staffsystem.staffsystem.repository;

import com.staffsystem.staffsystem.model.login.LoginUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUsuarioRepository extends JpaRepository<LoginUsuario, Long> {
    LoginUsuario findByEmailAndSenha(String email, String senha);
    LoginUsuario findByNome(String name);
}
