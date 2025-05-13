package com.dadosdabola.dados_da_bola.controller;

import com.dadosdabola.dados_da_bola.entities.Rodada;
import com.dadosdabola.dados_da_bola.service.RodadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rodadas")
public class RodadaController {

    @Autowired
    private RodadaService service;

    @GetMapping
    public ResponseEntity<List<Rodada>> buscarRodadas() {
        List<Rodada> lista = service.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Rodada> buscarPoId(@PathVariable Long id){
        Rodada rodada = service.findById(id);
        return ResponseEntity.ok().body(rodada);
    }

    @PostMapping
    public ResponseEntity<Rodada> inserirRodada(@RequestBody Rodada rodada){
        Rodada rodadaInserida = service.insert(rodada);
        return new ResponseEntity<>(rodadaInserida, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Rodada> atualizarRodada(@PathVariable Long id, @RequestBody Rodada rodada){
        Rodada rodadaSalva = service.update(id, rodada);
        return ResponseEntity.ok().body(rodadaSalva);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarRodada(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
