package br.com.desafio.dto;

import br.com.desafio.model.Pessoa;
import br.com.desafio.model.Tarefa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PessoaTarefaDTO {
    private Pessoa pessoa;
    private Tarefa tarefa;
}
