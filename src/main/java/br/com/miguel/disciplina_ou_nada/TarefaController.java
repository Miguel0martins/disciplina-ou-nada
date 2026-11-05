package br.com.miguel.disciplina_ou_nada;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/cobranca")
    public String cobranca() {
        int atrasadas = gerenciador.getAtrasadas().size();
        if (atrasadas == 0) {
            return "Tudo em dia. Continua assim!";
        }
        return "Você tem " + atrasadas + " tarefa(s) atrasada(s). Disciplina ou nada!";
    }

    @PostMapping
    public Tarefa adicionar(@RequestBody NovaTarefa nova) {
        gerenciador.adicionar(nova.titulo(), nova.descricao(), nova.prazo());
        List<Tarefa> lista = gerenciador.getTarefas();
        return lista.get(lista.size() - 1);
    }

    @PutMapping("/{indice}/concluir")
    public List<Tarefa> concluir(@PathVariable int indice) {
        gerenciador.concluir(indice);
        return gerenciador.getTarefas();
    }

    @DeleteMapping("/{indice}")
    public List<Tarefa> remover(@PathVariable int indice) {
        gerenciador.remover(indice);
        return gerenciador.getTarefas();
    }
}