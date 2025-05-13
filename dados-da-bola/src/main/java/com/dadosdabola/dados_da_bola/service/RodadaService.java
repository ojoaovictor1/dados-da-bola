package com.dadosdabola.dados_da_bola.service;

import com.dadosdabola.dados_da_bola.entities.Rodada;
import com.dadosdabola.dados_da_bola.repository.RodadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RodadaService {

    @Autowired
    RodadaRepository rodadaRepository;

    public List<Rodada> findAll(){
        return rodadaRepository.findAll();
    }

    public Rodada findById(Long id){
        Optional<Rodada> obj = rodadaRepository.findById(id);
        return obj.get();
    }

    public Rodada insert(Rodada rodada){
        return rodadaRepository.save(rodada);
    }

    public void delete(Long id){
        rodadaRepository.deleteById(id);
    }

    public Rodada update(Long id, Rodada novaRodada){
        Rodada entity = rodadaRepository.getReferenceById(id);
        updateData(entity, novaRodada);
        return rodadaRepository.save(entity);
    }

    public void updateData(Rodada rodadaAntiga, Rodada novaRodada){
        rodadaAntiga.setNumero(novaRodada.getNumero());
        rodadaAntiga.setData_inicio(novaRodada.getData_inicio());
        rodadaAntiga.setData_fim(novaRodada.getData_fim());
    }
}
