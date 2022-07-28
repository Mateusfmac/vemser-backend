package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.LoginDTO;
import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;
    
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    
    private final ObjectMapper objectMapper;
    
    //buscar usuario e senha no db
    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }
    
    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }
    
    
    public LoginDTO createUser(LoginDTO loginDTO) {
        UsuarioEntity usuarioEntity = objectMapper.convertValue(loginDTO, UsuarioEntity.class);
        usuarioEntity.setLogin(loginDTO.getLogin());
        usuarioEntity.setSenha(bCryptPasswordEncoder.encode(loginDTO.getSenha()));
        usuarioRepository.save(usuarioEntity);
        
        return objectMapper.convertValue(usuarioEntity, LoginDTO.class);
    }
    
    
    public Optional<UsuarioEntity> findById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }
    
    
}
