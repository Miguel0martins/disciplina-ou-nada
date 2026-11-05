package br.com.miguel.disciplina_ou_nada;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private LocalDate prazo;
    private boolean concluida;

    public Tarefa() {
    }

    public Long getId() {
        return id;
    }

    public Tarefa(String titulo, String descricao, LocalDate prazo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.concluida = false;
    }

    public boolean estaAtrasada() {
        return !concluida && prazo.isBefore(LocalDate.now());
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @Override
    public String toString() {
        String status = concluida ? "[✔ Concluída]" : (estaAtrasada() ? "[⚠ ATRASADA]" : "[⏳ Pendente]");
        return status + " " + titulo + " (Prazo: " + prazo + ")\n   Descrição: " + descricao;
    }
}