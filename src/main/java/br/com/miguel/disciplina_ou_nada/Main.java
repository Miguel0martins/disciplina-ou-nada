package br.com.miguel.disciplina_ou_nada;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        // Adicionando tarefas
        gerenciador.adicionar(
                "Entregar relatório",
                "Finalizar métricas financeiras do mês",
                LocalDate.of(2026, 11, 10)
        );
        gerenciador.adicionar(
                "Estudar Java",
                "Praticar Programação Orientada a Objetos",
                LocalDate.of(2026, 11, 10)
        );

        gerenciador.adicionar("Teste atrasada", "Tarefa de teste", LocalDate.now().minusDays(1));
        System.out.println(gerenciador.getTarefas().get(2).estaAtrasada());

        // Listando todas
        gerenciador.listar();

        // Concluindo a tarefa número 1
        gerenciador.concluir(1);

        // Listando novamente para ver o status atualizado
        gerenciador.listar();
    }
}