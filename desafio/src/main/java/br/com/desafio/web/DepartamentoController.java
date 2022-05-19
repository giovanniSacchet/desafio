package br.com.desafio.web;

import br.com.desafio.dto.DepartamentoDTO;
import br.com.desafio.model.Departamento;
import br.com.desafio.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    @Autowired
    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PostMapping("/departamento")
    public Departamento createDepartamento(@RequestBody Departamento departamento) {
        return this.departamentoService.save(departamento);
    }

    @GetMapping("/departamentos")
    public List<DepartamentoDTO> getDeparmentos() {
        return this.departamentoService.getDepartamentos();
    }

}
