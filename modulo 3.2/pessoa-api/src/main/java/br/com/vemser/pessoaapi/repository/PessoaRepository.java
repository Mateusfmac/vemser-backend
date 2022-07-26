package br.com.vemser.pessoaapi.repository;


import br.com.vemser.pessoaapi.dto.RelatorioPessoaDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNomeContainsIgnoreCase(String nome);
    
    PessoaEntity findByCpf(String cpf);
    
    @Query(value = " select new br.com.vemser.pessoaapi.dto.RelatorioPessoaDTO( " +
            "p.idPessoa, " +
            "p.nome, " +
            "p.email, " +
            "c.numero, " +
            "e.cep, " +
            "e.cidade, " +
            "e.estado, " +
            "e.pais, " +
            "pe.nome" +
              ")" +
            "from PESSOA p " +
            "left join p.contatos c " +
            "left join p.enderecos e " +
            "left join p.pet pe " +
            "where (:idPessoa is null or p.idPessoa = :idPessoa)")
    List<RelatorioPessoaDTO> relatorioPessoa(@Param("idPessoa") Integer idPessoa);
}
