package com.staffsystem.staffsystem.model.atestados;

import java.util.Date;

public class AtestadoRetornoFuncionario {
    private String dataSolicitacao;
    private String dataInicioAfastamento;
    private int diasAfastados;
    private int validado;

    public String getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(String dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getDataInicioAfastamento() {
        return dataInicioAfastamento;
    }

    public void setDataInicioAfastamento(String dataInicioAfastamento) {
        this.dataInicioAfastamento = dataInicioAfastamento;
    }

    public int getDiasAfastados() {
        return diasAfastados;
    }

    public void setDiasAfastados(int diasAfastados) {
        this.diasAfastados = diasAfastados;
    }

    public int getValidado() {
        return validado;
    }

    public void setValidado(int validado) {
        this.validado = validado;
    }
}
