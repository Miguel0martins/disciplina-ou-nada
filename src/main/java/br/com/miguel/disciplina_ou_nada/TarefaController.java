package br.com.miguel.disciplina_ou_nada;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return repository.findAll();
    }

    @GetMapping("/atrasadas")
    public List<Tarefa> atrasadas() {
        List<Tarefa> atrasadas = new ArrayList<>();
        for (Tarefa t : repository.findAll()) {
            if (t.estaAtrasada()) {
                atrasadas.add(t);
            }
        }
        return atrasadas;
    }

    @GetMapping("/cobranca")
    public String cobranca() {
        int total = atrasadas().size();
        if (total == 0) {
            return "Tudo em dia. Continua assim!";
        }
        return "Você tem " + total + " tarefa(s) atrasada(s). Disciplina ou nada!";
    }

    @PostMapping
    public Tarefa adicionar(@RequestBody NovaTarefa nova) {
        Tarefa tarefa = new Tarefa(nova.titulo(), nova.descricao(), nova.prazo());
        return repository.save(tarefa);
    }

    @PutMapping("/{id}/concluir")
    public Tarefa concluir(@PathVariable Long id) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        tarefa.setConcluida(true);
        return repository.save(tarefa);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
    }
}