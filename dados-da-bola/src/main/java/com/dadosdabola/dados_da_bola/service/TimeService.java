package com.dadosdabola.dados_da_bola.service;

import com.dadosdabola.dados_da_bola.entities.Time;
import com.dadosdabola.dados_da_bola.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    TimeRepository timeRepository;

    public List<Time> findAll(){
        return timeRepository.findAll();
    }

    public Time findById(Long id){
        Optional<Time> obj = timeRepository.findById(id);
        return obj.get();
    }

    public Time insert(Time time){
        return timeRepository.save(time);
    }

    public void delete(Long id){
        timeRepository.deleteById(id);
    }

    public Time update(Long id, Time novoTime){
        Time entity = timeRepository.getReferenceById(id);
        updateData(entity, novoTime);
        return timeRepository.save(entity);
    }

    public void updateData(Time timeAntigo, Time novoTime){
        timeAntigo.setNome(novoTime.getNome());
        timeAntigo.setSigla(novoTime.getSigla());
        timeAntigo.setEscudo_url(novoTime.getEscudo_url());
    }
}
