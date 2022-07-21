package br.com.vemser.pessoaapi.repository;


import br.com.vemser.pessoaapi.entity.EnderecoEntity;
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
    
   /* PessoaEntity findByNascimentoBetween(Date inicio, Date fim);*/
   
}
