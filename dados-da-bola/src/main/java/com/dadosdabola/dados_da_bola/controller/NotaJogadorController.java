package com.dadosdabola.dados_da_bola.controller;

import com.dadosdabola.dados_da_bola.entities.NotaJogador;
import com.dadosdabola.dados_da_bola.entities.Time;
import com.dadosdabola.dados_da_bola.service.NotaJogadorService;
import com.dadosdabola.dados_da_bola.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/notas")
public class NotaJogadorController {

    @Autowired
    private NotaJogadorService service;

    @GetMapping
    public ResponseEntity<List<NotaJogador>> buscarNotas() {
        List<NotaJogador> lista = service.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<NotaJogador> buscarPoId(@PathVariable Long id){
        NotaJogador nota = service.findById(id);
        return ResponseEntity.ok().body(nota);
    }

    @PostMapping
    public ResponseEntity<NotaJogador> inserirNotas(@RequestBody NotaJogador notaJogador){
        NotaJogador notaInserida = service.insert(notaJogador);
        return new ResponseEntity<>(notaInserida, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<NotaJogador> atualizarNota(@PathVariable Long id, @RequestBody NotaJogador nota){
        NotaJogador notaSalva = service.update(id, nota);
        return ResponseEntity.ok().body(notaSalva);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarNota(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
