package br.com.vemser.pessoaapi.security;

import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<UsuarioEntity> usuarioEntity = usuarioService.findByLogin(username);
        return usuarioEntity
                .orElseThrow(()-> new UsernameNotFoundException("Usuario nao encontrado"));
    }
}
