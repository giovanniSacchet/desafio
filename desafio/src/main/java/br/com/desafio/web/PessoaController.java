package br.com.desafio.web;

import br.com.desafio.dto.PessoaDTO;
import br.com.desafio.dto.PessoasHorasGastasDTO;
import br.com.desafio.model.Pessoa;
import br.com.desafio.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping("/pessoas")
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        return this.pessoaService.save(pessoa);
    }

    @PutMapping("/pessoas")
    public Pessoa editarPessoa(@RequestBody Pessoa pessoa) {
        return this.pessoaService.save(pessoa);
    }

    @DeleteMapping("/pessoas/{id}")
    public void deletarPessoa(@PathVariable(value = "id") Long pessoaId)  {
        pessoaService.deleteById(pessoaId);
    }

    @GetMapping("/pessoas")
    public List<PessoasHorasGastasDTO> getPessoasHorasGastas() {
        return this.pessoaService.getPessoasHorasGastas();
    }

    @GetMapping("/pessoas/gastos")
    public float mediaHorasGastas(@RequestBody PessoaDTO pessoaDTO) {
        return this.pessoaService.getMediaHorasGastas(pessoaDTO);
    }
}
