package com.staffsystem.staffsystem.repository;

import com.staffsystem.staffsystem.model.atestados.AtestadosUsuario;
import com.staffsystem.staffsystem.model.login.LoginUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AtestadosUsuarioRepository extends JpaRepository<AtestadosUsuario, Long> {
    @Query("SELECT a FROM AtestadosUsuario a WHERE a.idUsuario.id = :idUsuario")
    List<AtestadosUsuario> buscaUsuarioId(long idUsuario);
}
