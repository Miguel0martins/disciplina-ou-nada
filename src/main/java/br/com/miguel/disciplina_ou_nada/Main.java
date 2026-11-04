package br.com.miguel.disciplina_ou_nada;

public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        // Adicionando tarefas
        gerenciador.adicionar(
                "Entregar relatório",
                "Finalizar métricas financeiras do mês",
                "10/11/2026"
        );
        gerenciador.adicionar(
                "Estudar Java",
                "Praticar Programação Orientada a Objetos",
                "Amanhã"
        );

        // Listando todas
        gerenciador.listar();

        // Concluindo a tarefa número 1
        gerenciador.concluir(1);

        // Listando novamente para ver o status atualizado
        gerenciador.listar();
    }
}