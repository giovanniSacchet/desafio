package br.com.desafio.service;

import br.com.desafio.dto.PessoaTarefaDTO;
import br.com.desafio.dto.TarefasPorDepartamentoDTO;
import br.com.desafio.model.Departamento;
import br.com.desafio.model.Tarefa;
import br.com.desafio.repository.DepartamentoRepository;
import br.com.desafio.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaServiceImpl extends ServiceImpl<Tarefa> implements TarefaService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    public TarefaServiceImpl(TarefaRepository repository) {
        super(repository);
    }

    @Override
    public Tarefa alocarPessoaTarefa(PessoaTarefaDTO pessoaTarefaDTO) {
        if (pessoaTarefaDTO.getTarefa().getDepartamento() == pessoaTarefaDTO.getPessoa().getDepartamento()) {
            Tarefa tarefa = pessoaTarefaDTO.getTarefa();
            tarefa.setPessoa(pessoaTarefaDTO.getPessoa());
            return getRepository().save(tarefa);
        }
        return null;
    }

    @Override
    public Tarefa finalizarTarefa(Long idTarefa) {
        Optional<Tarefa> tarefa = getRepository().findById(idTarefa);
        if(tarefa.isPresent()) {
            Tarefa tarefaFinalizada = tarefa.get();
            tarefaFinalizada.setFinalizado(true);
            getRepository().save(tarefaFinalizada);
            return tarefaFinalizada;
        }
        return null;
    }

    @Override
    public List<TarefasPorDepartamentoDTO> getTarefasPorDepartamentoFinalizadas() {
        List<Tarefa> tarefas = getRepository().findAll();
        List<Departamento> departamentos = departamentoRepository.findAll();
        List<TarefasPorDepartamentoDTO> listaDTO = new ArrayList<>();
        TarefasPorDepartamentoDTO dto;
        Integer finalizadas, pendentes;
        for(Departamento d : departamentos) {
            dto = new TarefasPorDepartamentoDTO();
            dto.setDepartamento(d.getTitulo());
            finalizadas = 0;
            pendentes = 0;
            for(Tarefa t : tarefas) {
                if(t.getDepartamento().getId() == d.getId()) {
                    if(t.getFinalizado()) {
                        finalizadas++;
                    } else {
                        pendentes++;
                    }
                }
            }
            dto.setTarefasFinalizadas(finalizadas);
            dto.setTerafasPendentes(pendentes);
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}