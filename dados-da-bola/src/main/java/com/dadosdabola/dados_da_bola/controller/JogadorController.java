package com.dadosdabola.dados_da_bola.controller;

import com.dadosdabola.dados_da_bola.entities.Jogador;
import com.dadosdabola.dados_da_bola.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService service;

    @GetMapping
    public ResponseEntity<List<Jogador>> buscarJogadores() {
        List<Jogador> lista = service.findAll();
        return ResponseEntity.ok(lista);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Jogador> buscarPoId(@PathVariable Long id){
        Jogador jogador = service.findById(id);
        return ResponseEntity.ok().body(jogador);
    }

    @PostMapping
    public ResponseEntity<Jogador> inserirJogador(@RequestBody Jogador jogador){
        Jogador timeInserido = service.insert(jogador);
        return new ResponseEntity<>(timeInserido, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Jogador> atualizarJogador(@PathVariable Long id, @RequestBody Jogador jogador){
        Jogador timeSalvo = service.update(id, jogador);
        return ResponseEntity.ok().body(timeSalvo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarJogador(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
