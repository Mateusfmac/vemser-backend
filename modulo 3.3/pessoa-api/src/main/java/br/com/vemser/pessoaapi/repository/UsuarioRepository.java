package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    
    Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha);
    
    Optional<UsuarioEntity> findByLogin(String login);
}
