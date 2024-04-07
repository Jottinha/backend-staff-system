package com.staffsystem.staffsystem.model.login;

public class LoginRetorno {
    private String name;
    private String permissao;

    public LoginRetorno(String name, String permissao) {
        this.name = name;
        this.permissao = permissao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
}
