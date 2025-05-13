package com.dadosdabola.dados_da_bola.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Rodada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private String data_inicio;
    private String data_fim;

    public Rodada(){

    }

    public Rodada(int numero, String data_inicio, String data_fim) {
        this.numero = numero;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
    }

    public Long getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rodada rodada = (Rodada) o;
        return Objects.equals(id, rodada.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
