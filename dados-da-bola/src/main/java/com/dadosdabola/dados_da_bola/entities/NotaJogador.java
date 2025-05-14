package com.dadosdabola.dados_da_bola.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class NotaJogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jogador_id")
    private Jogador jogador;

    @ManyToOne
    @JoinColumn(name = "rodada_id")
    private Rodada rodada;

    private double nota;
    private int gols;
    private int assistencias;
    boolean selecao_rodada;

    public NotaJogador(){

    }

    public NotaJogador(Jogador jogador, Rodada rodada, double nota, int gols, int assistencias, boolean selecao_rodada) {
        this.jogador = jogador;
        this.rodada = rodada;
        this.nota = nota;
        this.gols = gols;
        this.assistencias = assistencias;
        this.selecao_rodada = selecao_rodada;
    }

    public Long getId() {
        return id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public Rodada getRodada() {
        return rodada;
    }

    public void setRodada(Rodada rodada) {
        this.rodada = rodada;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public int getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(int assistencias) {
        this.assistencias = assistencias;
    }

    public boolean isSelecao_rodada() {
        return selecao_rodada;
    }

    public void setSelecao_rodada(boolean selecao_rodada) {
        this.selecao_rodada = selecao_rodada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotaJogador that = (NotaJogador) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
