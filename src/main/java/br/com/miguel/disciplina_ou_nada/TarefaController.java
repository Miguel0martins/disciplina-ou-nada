package br.com.miguel.disciplina_ou_nada;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final GerenciadorTarefas gerenciador = new GerenciadorTarefas();

    public TarefaController() {
        gerenciador.adicionar("Estudar Java", "Praticar Spring Boot", LocalDate.now().plusDays(1));
        gerenciador.adicionar("Entregar relatório", "Fechar métricas", LocalDate.now().minusDays(1));

    }


    @GetMapping
    public List<Tarefa> listar() {
        return gerenciador.getTarefas();
    }

    @GetMapping("/atrasadas")
    public List<Tarefa> atrasadas() {
        return gerenciador.getAtrasadas();
    }
}