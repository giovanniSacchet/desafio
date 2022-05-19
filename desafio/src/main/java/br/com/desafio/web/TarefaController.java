package br.com.desafio.web;

import br.com.desafio.dto.PessoaTarefaDTO;
import br.com.desafio.dto.TarefasPorDepartamentoDTO;
import br.com.desafio.model.Tarefa;
import br.com.desafio.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TarefaController {

    private final TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("/tarefas")
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        tarefa.setPrazo(new Date());
        return this.tarefaService.save(tarefa);
    }

    @PutMapping("/tarefas/alocar")
    public Tarefa alocarPessoaTarefa(@RequestBody PessoaTarefaDTO pessoaTarefaDTO) {
        Tarefa tarefa = this.tarefaService.alocarPessoaTarefa(pessoaTarefaDTO);
        if(tarefa != null) {
            return tarefa;
        }
        return null;
    }

    @PutMapping("/tarefas/finalizar")
    public Tarefa finalizarTarefa(@RequestBody Tarefa tarefa) {
        return this.tarefaService.finalizarTarefa(tarefa.getId());
    }

    @GetMapping("/tarefas")
    public List<TarefasPorDepartamentoDTO> getTarefasPorDepartamentoFinalizadas() {
        return this.tarefaService.getTarefasPorDepartamentoFinalizadas();
    }

}
