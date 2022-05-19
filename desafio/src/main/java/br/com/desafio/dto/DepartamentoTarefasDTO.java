package br.com.desafio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DepartamentoTarefasDTO {
    private String departamento;
    private Integer tarefasFinalizadas;
    private Integer tarefasPendentes;
}
