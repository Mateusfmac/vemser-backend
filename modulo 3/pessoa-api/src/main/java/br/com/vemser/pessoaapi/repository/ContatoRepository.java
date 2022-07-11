package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.Contato;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class ContatoRepository {
    
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNT = new AtomicInteger();
   
    
    public ContatoRepository() {
        listaContatos.add(new Contato(COUNT.incrementAndGet(), 3, "COMERCIAL", "1852369851", "favor nao ligar"));
        listaContatos.add(new Contato(COUNT.incrementAndGet(), 5, "RESIDENCIAL", "1852369851", "favor nao ligar"));
        listaContatos.add(new Contato(COUNT.incrementAndGet(), 4, "RESIDENCIAL", "1852369851", "favor nao ligar"));
        listaContatos.add(new Contato(COUNT.incrementAndGet(), 2, "RESIDENCIAL", "1852369851", "favor nao ligar"));
        listaContatos.add(new Contato(COUNT.incrementAndGet(), 1, "COMERCIAL", "1852369851", "favor nao ligar"));
    }
    
    public Contato create(Contato contato) {
        contato.setIdContato(COUNT.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }
    
    public List<Contato> listar() {
        return listaContatos;
    }
}
