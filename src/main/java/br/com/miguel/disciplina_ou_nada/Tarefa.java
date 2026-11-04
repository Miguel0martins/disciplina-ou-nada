package br.com.miguel.disciplina_ou_nada;

import java.util.ArrayList;
import java.util.List;

// 1. Classe modelo da Tarefa
class Tarefa {
    private String titulo;
    private String descricao;
    private String prazo;
    private boolean concluida;

    public Tarefa(String titulo, String descricao, String prazo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.concluida = false;
    }

    // Getters e Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getPrazo() { return prazo; }
    public void setPrazo(String prazo) { this.prazo = prazo; }

    public boolean isConcluida() { return concluida; }
    public void setConcluida(boolean concluida) { this.concluida = concluida; }

    @Override
    public String toString() {
        String status = concluida ? "[✔ Concluída]" : "[⏳ Pendente]";
        return status + " " + titulo + " (Prazo: " + prazo + ")\n   Descrição: " + descricao;
    }
}

// 2. Classe Gerenciadora
class GerenciadorTarefas {
    private List<Tarefa> tarefas;

    public GerenciadorTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionar(String titulo, String descricao, String prazo) {
        Tarefa novaTarefa = new Tarefa(titulo, descricao, prazo);
        tarefas.add(novaTarefa);
        System.out.println("Tarefa \"" + titulo + "\" adicionada com sucesso!");
    }

    public void listar() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        System.out.println("\n--- SUAS TAREFAS ---");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println((i + 1) + ". " + tarefas.get(i));
        }
        System.out.println("--------------------\n");
    }

    public void concluir(int indice) {
        int pos = indice - 1; // Ajusta para índice base 0
        if (pos >= 0 && pos < tarefas.size()) {
            tarefas.get(pos).setConcluida(true);
            System.out.println("Tarefa \"" + tarefas.get(pos).getTitulo() + "\" concluída!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void remover(int indice) {
        int pos = indice - 1;
        if (pos >= 0 && pos < tarefas.size()) {
            Tarefa removida = tarefas.remove(pos);
            System.out.println("Tarefa \"" + removida.getTitulo() + "\" removida com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }
}
