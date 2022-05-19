package br.com.desafio.repository;

import br.com.desafio.model.Pessoa;
import br.com.desafio.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("from Tarefa t " +
            "inner join fetch t.pessoa p " +
            "where p.id = :idPessoa")
    List<Tarefa> findAllTarefasDaPessoa(@Param("idPessoa") Long idPessoa);

    Pessoa findByNome(String nome);

}