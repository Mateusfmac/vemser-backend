package br.com.vemser.pessoaapi.security;


import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    
    private final TokenService tokenService;
    private final static String BEARER = "Bearer ";
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        //recuperar token da req/header
        String token = getTokenFromHeader(request);
        Optional<UsuarioEntity> optionalUsuario = tokenService.validaToken(token);
        
        //verifica auth de user e senha e seta no spring.
        authenticate(optionalUsuario);
        
        filterChain.doFilter(request, response); //verifica o token em todas req e res
    }
    
    public void authenticate(Optional<UsuarioEntity> optionalUsuarioEntity) {
        //autenticar usuario
        boolean valido = !optionalUsuarioEntity.isEmpty();
        if (valido) { //seta usuario e senha no context holder se o token for valido... dps setar no http da config
            UsuarioEntity usuarioEntity = optionalUsuarioEntity.get();
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(usuarioEntity.getLogin(), null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        } else {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        
        
    }
    
    //recuperar token da req/header
    private String getTokenFromHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null) {
            return null;
        }
        return token.replace(BEARER, "");
    }
}
