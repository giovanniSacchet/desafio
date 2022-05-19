package br.com.desafio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TarefasPorDepartamentoDTO {
    private String departamento;
    private Integer tarefasFinalizadas;
    private Integer terafasPendentes;
}
