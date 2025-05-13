package com.dadosdabola.dados_da_bola.service;

import com.dadosdabola.dados_da_bola.entities.Jogador;
import com.dadosdabola.dados_da_bola.entities.Time;
import com.dadosdabola.dados_da_bola.repository.JogadorRepository;
import com.dadosdabola.dados_da_bola.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    JogadorRepository jogadorRepository;

    @Autowired
    TimeRepository timeRepository;

    public List<Jogador> findAll(){
        return jogadorRepository.findAll();
    }

    public Jogador findById(Long id){
        Optional<Jogador> obj = jogadorRepository.findById(id);
        return obj.get();
    }

    public Jogador insert(Jogador jogador){
        Long timeId = jogador.getTime().getId();
        Time time =  timeRepository.findById(timeId)
                .orElseThrow(() -> new RuntimeException("Time com id " + timeId + "não encontrado"));
        jogador.setTime(time);
        return jogadorRepository.save(jogador);
    }

    public void delete(Long id){
        jogadorRepository.deleteById(id);
    }

    public Jogador update(Long id, Jogador novoJogador){
        Jogador entity = jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador com id " + id + "não encontrado"));


        updateData(entity, novoJogador);
        return jogadorRepository.save(entity);
    }

    public void updateData(Jogador jogadorAntigo, Jogador novoJogador){
        jogadorAntigo.setNome(novoJogador.getNome());
        jogadorAntigo.setPosicao(novoJogador.getPosicao());

        Long timeId = novoJogador.getTime().getId();
        Time time = timeRepository.findById(timeId)
                .orElseThrow(() -> new RuntimeException("Time com id" + timeId + "não encontrado"));
        jogadorAntigo.setTime(novoJogador.getTime());

    }
}
