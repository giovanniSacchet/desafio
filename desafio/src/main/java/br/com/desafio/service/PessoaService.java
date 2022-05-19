package br.com.desafio.service;

import br.com.desafio.dto.PessoaDTO;
import br.com.desafio.dto.PessoasHorasGastasDTO;
import br.com.desafio.model.Pessoa;

import java.util.List;

public interface PessoaService extends Service<Pessoa> {

    List<PessoasHorasGastasDTO> getPessoasHorasGastas();

    float getMediaHorasGastas(PessoaDTO pessoaDTO);

}
