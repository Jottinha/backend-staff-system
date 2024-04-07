package com.staffsystem.staffsystem.model.login;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="loginusuario")
public class LoginUsuario {
    @Id
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String permissao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
}
