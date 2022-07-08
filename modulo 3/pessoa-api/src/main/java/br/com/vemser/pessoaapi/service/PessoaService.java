package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    
    public Pessoa create(Pessoa pessoa) throws RegraDeNegocioException {
        return pessoaRepository.create(pessoa);
    }
    
    public List<Pessoa> list() {
        return pessoaRepository.list();
    }
    
    public Pessoa buscaPorNome(String nome) throws RegraDeNegocioException {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("Nome nao encontrado"));
    }
    
    public Pessoa update(Integer id, Pessoa pessoaAtualizar) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = buscaIdPessoa(id);
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }
    
    public void delete(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = buscaIdPessoa(id);
        pessoaRepository.list().remove(pessoaRecuperada);
    }
    
    public Pessoa buscaIdPessoa(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("id Pessoa não econtrado"));
        
    }
}
