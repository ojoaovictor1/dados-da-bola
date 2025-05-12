package com.dadosdabola.dados_da_bola.controller;

import com.dadosdabola.dados_da_bola.entities.Time;
import com.dadosdabola.dados_da_bola.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/times")
public class TimeController {

    @Autowired
    private TimeService service;

    @GetMapping
    public ResponseEntity<List<Time>> buscarTimes() {
        List<Time> lista = service.findAll();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Time> inserirTime(@RequestBody Time time){
        Time timeInserido = service.insert(time);
        return new ResponseEntity<>(timeInserido, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Time> atualizarTime(@PathVariable Long id, @RequestBody Time time){
        Time timeSalvo = service.update(id, time);
        return ResponseEntity.ok().body(timeSalvo);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarTime(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
