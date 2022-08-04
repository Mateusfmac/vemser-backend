package br.com.vemser.pessoaapi.security;



import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    
    private final TokenService tokenService;
    protected final static String BEARER = "Bearer ";
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        //recuperar token da req/header
        String token = getTokenFromHeader(request);
        //verifica auth token e user.
        UsernamePasswordAuthenticationToken dtoDoSpringSecurity = tokenService.validaToken(token);
        
        //seta auth token e dto
        SecurityContextHolder.getContext().setAuthentication(dtoDoSpringSecurity);
        filterChain.doFilter(request, response); //verifica o token em todas req e res
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
