package com.dadosdabola.dados_da_bola.service;

import com.dadosdabola.dados_da_bola.entities.NotaJogador;
import com.dadosdabola.dados_da_bola.repository.NotaJogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaJogadorService {

    @Autowired
    NotaJogadorRepository notaJogadorRepository;

    public List<NotaJogador> findAll(){
        return notaJogadorRepository.findAll();
    }

    public NotaJogador findById(Long id){
        Optional<NotaJogador> obj = notaJogadorRepository.findById(id);
        return obj.get();
    }

    public NotaJogador insert(NotaJogador notaJogador){

        return notaJogadorRepository.save(notaJogador);
    }

    public void delete(Long id){
        notaJogadorRepository.deleteById(id);
    }

    public NotaJogador update(Long id, NotaJogador novaNotaJogador){
        NotaJogador entity = notaJogadorRepository.getReferenceById(id);
        updateData(entity, novaNotaJogador);
        return notaJogadorRepository.save(entity);
    }

    public void updateData(NotaJogador antigaNotaJogador, NotaJogador novaNotaJogador){
        antigaNotaJogador.setJogador(novaNotaJogador.getJogador());
        antigaNotaJogador.setRodada(novaNotaJogador.getRodada());
        antigaNotaJogador.setNota(novaNotaJogador.getNota());
        antigaNotaJogador.setGols(novaNotaJogador.getGols());
        antigaNotaJogador.setAssistencias(novaNotaJogador.getAssistencias());
        antigaNotaJogador.setSelecao_rodada(novaNotaJogador.isSelecao_rodada());
    }
}
