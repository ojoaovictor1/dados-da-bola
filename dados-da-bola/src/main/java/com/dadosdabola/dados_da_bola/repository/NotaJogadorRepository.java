package com.dadosdabola.dados_da_bola.repository;

import com.dadosdabola.dados_da_bola.entities.NotaJogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaJogadorRepository extends JpaRepository<NotaJogador, Long> {
    List<NotaJogador> findByRodadaId(Long rodadaId);
}
