package com.staffsystem.staffsystem.model.atestados;

import com.staffsystem.staffsystem.model.login.LoginUsuario;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name="atestadofuncionarios")
public class AtestadosUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private LoginUsuario idUsuario;
    @Column(name = "diasafastados")
    private int diasAfastados;
    @Column(name = "datainicioafastamento")
    private Date dataInicioAfastamento;
    @Column(name = "imagem")
    private String imagem;
    @Column(name="validado")
    private int validado;
    @Column(name="datasolicitacao ")
    private Date dataSolicitacao;

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public int getDiasAfastados() {
        return diasAfastados;
    }

    public int getValidado() {
        return validado;
    }

    public void setValidado(int validado) {
        this.validado = validado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LoginUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(LoginUsuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getDiasafastados() {
        return diasAfastados;
    }

    public void setDiasAfastados(int diasAfastados) {
        this.diasAfastados = diasAfastados;
    }

    public Date getDataInicioAfastamento() {
        return dataInicioAfastamento;
    }

    public void setDataInicioAfastamento(Date dataInicioAfastamento) {
        this.dataInicioAfastamento = dataInicioAfastamento;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
