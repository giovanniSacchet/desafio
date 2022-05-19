package br.com.desafio.dto;

import br.com.desafio.model.Tarefa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DepartamentoDTO {
    private String titulo;
    private Integer numeroPessoas;
    private List<Tarefa> tarefas;
}
