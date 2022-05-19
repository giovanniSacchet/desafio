package br.com.desafio.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PessoasHorasGastasDTO {
    private String nome;
    private String departamento;
    private Integer totalHorasGastas;
}
