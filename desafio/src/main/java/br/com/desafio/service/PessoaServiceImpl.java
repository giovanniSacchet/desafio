package br.com.desafio.service;

import br.com.desafio.dto.PessoaDTO;
import br.com.desafio.dto.PessoasHorasGastasDTO;
import br.com.desafio.model.Pessoa;
import br.com.desafio.model.Tarefa;
import br.com.desafio.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaServiceImpl extends ServiceImpl<Pessoa> implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaServiceImpl(PessoaRepository repository) {
        super(repository);
    }

    @Override
    public List<PessoasHorasGastasDTO> getPessoasHorasGastas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        List<Tarefa> tarefasDaPessoa;
        List<PessoasHorasGastasDTO> listaDTO = new ArrayList<>();
        PessoasHorasGastasDTO obj;
        Integer totalHoras;

        for(Pessoa p : pessoas) {
            tarefasDaPessoa = pessoaRepository.findAllTarefasDaPessoa(p.getId());
            totalHoras = 0;
            for(Tarefa t : tarefasDaPessoa) {
                totalHoras += t.getDuracao();
            }
            obj = new PessoasHorasGastasDTO();
            obj.setNome(p.getNome());
            obj.setDepartamento(p.getDepartamento().getTitulo());
            obj.setTotalHorasGastas(totalHoras);
            listaDTO.add(obj);
        }
        return listaDTO;
    }

    @Override
    public float getMediaHorasGastas(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaRepository.findByNome(pessoaDTO.getNome());
        if(pessoa != null) {
            List<Tarefa> tarefas = pessoaRepository.findAllTarefasDaPessoa(pessoa.getId());
            Integer soma = 0;
            float media;
            for(Tarefa t : tarefas) {
                soma += t.getDuracao();
            }
            media = soma / tarefas.size();
            return media;
        }
        return 0;
    }

}