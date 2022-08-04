package br.com.vemser.pessoaapi.testecriadordesenha;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class TesteCriadorDeSenha {
    public static void main(String[] args) {
        StandardPasswordEncoder standardPasswordEncoder = new StandardPasswordEncoder();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senha = bCryptPasswordEncoder.encode("123");
        String senhaPass = standardPasswordEncoder.encode("123");
        System.out.println(senhaPass);
        
        //Obrigado pelo token errado no script do DB :)
        //String minhaSenhacrypt = "$2a$10$OSdKzw0K0LaLPyj1EqOWte8U.cpTftzycrK5eQ/Wgu2GfB4wgpWu6";
        String passEncod = "4bc1f54186b76ac8173c2747991ab1e87698543c5f3a5455daa681ba31177223ea6460759f1a59bc";
        boolean matchEncode = standardPasswordEncoder.matches("123", passEncod);
       // boolean match = bCryptPasswordEncoder.matches("123", minhaSenhacrypt);
        System.out.println(matchEncode);
    }
}
