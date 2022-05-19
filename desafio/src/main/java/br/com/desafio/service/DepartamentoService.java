package br.com.desafio.service;

import br.com.desafio.dto.DepartamentoDTO;
import br.com.desafio.model.Departamento;

import java.util.List;

public interface DepartamentoService extends Service<Departamento> {
    List<DepartamentoDTO> getDepartamentos();
}
