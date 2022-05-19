package br.com.desafio.service;

import br.com.desafio.dto.DepartamentoDTO;
import br.com.desafio.model.Departamento;
import br.com.desafio.model.Pessoa;
import br.com.desafio.model.Tarefa;
import br.com.desafio.repository.DepartamentoRepository;
import br.com.desafio.repository.PessoaRepository;
import br.com.desafio.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartamentoServiceImpl extends ServiceImpl<Departamento> implements DepartamentoService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    public DepartamentoServiceImpl(DepartamentoRepository repository) {
        super(repository);
    }

    @Override
    public List<DepartamentoDTO> getDepartamentos() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<Tarefa> tarefas = tarefaRepository.findAll();
        List<Departamento> departamentos = getRepository().findAll();
        List<DepartamentoDTO> listaDto = new ArrayList<>();
        List<Tarefa> tarefasDepartamento = new ArrayList<>();
        DepartamentoDTO dto;
        Integer contador;
        for(Departamento d : departamentos) {
            dto = new DepartamentoDTO();
            dto.setTitulo(d.getTitulo());
            contador = 0;
            for(Pessoa p : pessoas) {
                if(d.getId() == p.getDepartamento().getId()) {
                    contador++;
                }
            }
            dto.setNumeroPessoas(contador);
            for(Tarefa t : tarefas) {
                if(d.getId() == t.getDepartamento().getId()) {
                    tarefasDepartamento.add(t);
                }
            }
            dto.setTarefas(tarefasDepartamento);
            listaDto.add(dto);
        }
        return listaDto;
    }
}
