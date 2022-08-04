package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.LoginDTO;
import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.security.TokenService;
import br.com.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequiredArgsConstructor
@Validated
@RequestMapping("/auth")
@RestController
public class AuthController {
    
    private final UsuarioService usuarioService;
    private final TokenService tokenService;
    
    private final AuthenticationManager authenticationManager;
    
    //verificar usuario e senha
    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) throws RegraDeNegocioException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getLogin(),
                        loginDTO.getSenha()
                );
        //autentica
        Authentication authentication = authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);
        
        Object usuarioLogado = authentication.getPrincipal();
        UsuarioEntity usuarioEntity = (UsuarioEntity) usuarioLogado;
        
        String token = tokenService.getToken(usuarioEntity);
        return token;
    }
    
    @PostMapping("/create")
    public LoginDTO create(@RequestBody @Valid LoginDTO loginDTO) {
        return usuarioService.createUser(loginDTO);
    }
    
    @GetMapping("/usuario-logado")
    public Optional<UsuarioEntity> getLoggedUser() throws RegraDeNegocioException {
        return usuarioService.getLoggedUser();
    }
    
}
