package br.com.miguel.disciplina_ou_nada;

import java.time.LocalDate;

public record NovaTarefa(String titulo, String descricao, LocalDate prazo) {
}