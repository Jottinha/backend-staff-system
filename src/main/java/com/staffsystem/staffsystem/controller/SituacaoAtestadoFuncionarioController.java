package com.staffsystem.staffsystem.controller;

import com.staffsystem.staffsystem.model.NomeDTO;
import com.staffsystem.staffsystem.model.atestados.AtestadoRetornoFuncionario;
import com.staffsystem.staffsystem.model.atestados.AtestadosUsuario;
import com.staffsystem.staffsystem.model.login.LoginUsuario;
import com.staffsystem.staffsystem.repository.AtestadosUsuarioRepository;
import com.staffsystem.staffsystem.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/consulta/funcionario")
public class SituacaoAtestadoFuncionarioController {

    @Autowired
    private AtestadosUsuarioRepository atestadosUsuarioRepository;
    private UsuarioService serviceUsuario;

    public SituacaoAtestadoFuncionarioController(UsuarioService serviceUsuario) {
        this.serviceUsuario = serviceUsuario;
    }

    @PostMapping
    public ResponseEntity<List<AtestadoRetornoFuncionario>> getSituacaoAtestadoFuncionario(@RequestBody NomeDTO nome) {
        // Procura o usuário pelo nome na tabela de atestadofuncionarios
        LoginUsuario usuario = serviceUsuario.getUsuarioByName(nome.nome());
        List<AtestadosUsuario> atestadosUsuario = atestadosUsuarioRepository.buscaUsuarioId(usuario.getId());
        if (atestadosUsuario.isEmpty()) {
            // Retorna 404 Not Found se o usuário não for encontrado
            return ResponseEntity.notFound().build();
        }
        List<AtestadoRetornoFuncionario> lista = new ArrayList<AtestadoRetornoFuncionario>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        for (AtestadosUsuario usu : atestadosUsuario){
            AtestadoRetornoFuncionario retorno = new AtestadoRetornoFuncionario();
            retorno.setDataInicioAfastamento(formatter.format(usu.getDataInicioAfastamento()));
            retorno.setDataSolicitacao(formatter.format(usu.getDataSolicitacao()));
            retorno.setDiasAfastados(usu.getDiasAfastados());
            retorno.setValidado(usu.getValidado());
            lista.add(retorno);
        }

        // Retorna os dados do atestado relacionados ao usuário
        return ResponseEntity.ok(lista);
    }
}

