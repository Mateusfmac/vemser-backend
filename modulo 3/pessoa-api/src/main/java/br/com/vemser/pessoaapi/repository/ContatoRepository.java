package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {
    
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNT = new AtomicInteger();
    PessoaRepository pessoaRepository = new PessoaRepository();
    
    public ContatoRepository() {
        listaContatos.add(new Contato(COUNT.incrementAndGet(), 3, "COMERCIAL", "1852369851", "favor nao ligar"));
        listaContatos.add(new Contato(COUNT.incrementAndGet(), 5, "RESIDENCIAL", "1852369851", "favor nao ligar"));
        listaContatos.add(new Contato(COUNT.incrementAndGet(), 4, "RESIDENCIAL", "1852369851", "favor nao ligar"));
        listaContatos.add(new Contato(COUNT.incrementAndGet(), 2, "RESIDENCIAL", "1852369851", "favor nao ligar"));
        listaContatos.add(new Contato(COUNT.incrementAndGet(), 1, "COMERCIAL", "1852369851", "favor nao ligar"));
    }
    
    //criar
    public Contato create(Integer id, Contato contato) throws Exception {
        pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("id nao encontrado"));
        contato.setIdContato(COUNT.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }
    
    //listar
    public List<Contato> listar() {
        return listaContatos;
    }
    
    //atualizar
    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        Contato contatoLista = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato nao encontrado"));
        contatoLista.setTipoContato(contatoAtualizar.getTipoContato());
        contatoLista.setNumero(contatoAtualizar.getNumero());
        contatoLista.setDescricao(contatoAtualizar.getDescricao());
        return contatoLista;
    }
    
    //deletar
    public void delete(Integer id) throws Exception {
        Contato contatoLista = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato nao encontrado"));
        listaContatos.remove(contatoLista);
    }
    
    public List<Contato> contatoIdPessoa(Integer id) {
        return listaContatos.stream().filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }
}