package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;

import java.util.List;

public class ContatoService {
    private ContatoRepository contatoRepository;
    private PessoaRepository pessoaRepository;
    
    public ContatoService() {
        contatoRepository = new ContatoRepository();
    }
    
    public Contato create(Integer id, Contato contato) throws Exception {
        return contatoRepository.create(id, contato);
    }
    
    public List<Contato> listar() throws Exception {
        return contatoRepository.listar();
    }
    
    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        return contatoRepository.update(id, contatoAtualizar);
    }
    
    public void delete(Integer id) throws Exception {
        contatoRepository.delete(id);
    }
    
    public List<Contato> contatoIdPessoa (Integer id) {
        return contatoRepository.contatoIdPessoa(id);
    }
    
}
