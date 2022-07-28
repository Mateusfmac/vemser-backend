package br.com.vemser.pessoaapi.testecriadordesenha;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TesteCriadorDeSenha {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senha = bCryptPasswordEncoder.encode("123");
        System.out.println(senha);
        
        //Obrigado pelo token errado no script do DB :)
        String minhaSenhacrypt = "$2a$10$OSdKzw0K0LaLPyj1EqOWte8U.cpTftzycrK5eQ/Wgu2GfB4wgpWu6";
        boolean match = bCryptPasswordEncoder.matches("123", minhaSenhacrypt);
        System.out.println(match);
    }
}
