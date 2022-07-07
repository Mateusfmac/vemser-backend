package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;
    
    public ContatoService() {
        //contatoRepository = new ContatoRepository();
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
