package br.com.miguel.disciplina_ou_nada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    private List<Tarefa> tarefas;

    public GerenciadorTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionar(String titulo, String descricao, LocalDate prazo) {
        Tarefa novaTarefa = new Tarefa(titulo, descricao, prazo);
        tarefas.add(novaTarefa);
        System.out.println("Tarefa \"" + titulo + "\" adicionada com sucesso!");
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public List<Tarefa> getAtrasadas() {
        List<Tarefa> atrasadas = new ArrayList<>();
        for (Tarefa t : tarefas) {
            if (t.estaAtrasada()) {
                atrasadas.add(t);
            }
        }
        return atrasadas;
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

