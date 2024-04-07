package com.staffsystem.staffsystem.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.staffsystem.staffsystem.model.atestados.AtestadoDTO;
import com.staffsystem.staffsystem.model.atestados.AtestadosUsuario;
import com.staffsystem.staffsystem.repository.AtestadosUsuarioRepository;
import com.staffsystem.staffsystem.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/atestado")
public class AtestadoController {
    @Autowired
    AtestadosUsuarioRepository repository;
    private UsuarioService serviceUsuario;

    public AtestadoController(UsuarioService serviceUsuario) {
        this.serviceUsuario = serviceUsuario;
    }

    @PostMapping
    public ResponseEntity<String> salvarAtestado(@RequestBody AtestadoDTO atestadoDTO) {
        // Extrair os dados do DTO
        AtestadosUsuario novoAtestado = new AtestadosUsuario();

        int diasAfastado = atestadoDTO.diasAfastado();
        Date dataAfastamento = atestadoDTO.dataAfastamento();
        String linkReferencia = atestadoDTO.linkReferencia();
        String nome = atestadoDTO.nomeColaborador();;

        novoAtestado.setDiasAfastados(diasAfastado);
        novoAtestado.setDataInicioAfastamento(dataAfastamento);
        novoAtestado.setImagem(linkReferencia);
        novoAtestado.setValidado(atestadoDTO.validado());
        novoAtestado.setIdUsuario(serviceUsuario.getUsuarioByName(nome));

        Date dataAtual = new Date();
        novoAtestado.setDataSolicitacao(dataAtual);

        repository.save(novoAtestado);
        return ResponseEntity.status(HttpStatus.OK).body("Atestado salvo com sucesso!");
    }
}
