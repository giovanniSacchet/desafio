package br.com.desafio.service;

import br.com.desafio.dto.PessoaTarefaDTO;
import br.com.desafio.dto.TarefasPorDepartamentoDTO;
import br.com.desafio.model.Tarefa;

import java.util.List;

public interface TarefaService extends Service<Tarefa> {

    Tarefa alocarPessoaTarefa(PessoaTarefaDTO pessoaTarefaDTO);

    Tarefa finalizarTarefa(Long idTarefa);

    List<TarefasPorDepartamentoDTO> getTarefasPorDepartamentoFinalizadas();
}
