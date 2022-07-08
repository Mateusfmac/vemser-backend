package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.el.ELException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;
    
    @Autowired
    private PessoaService pessoaService;
    
    public Contato create(Integer id, Contato contato) throws RegraDeNegocioException {
        Pessoa pessoa = pessoaService.buscaIdPessoa(id);
        contato.setIdPessoa(id);
        return contatoRepository.create(contato);
    }
    
    public List<Contato> listar() {
        return contatoRepository.listar();
    }
    
    public Contato listarIdPessoa (Integer id) throws RegraDeNegocioException {
       return contatoRepository.listar().stream()
               .filter(contato -> contato.getIdPessoa().equals(id))
               .findFirst()
               .orElseThrow(()-> new RegraDeNegocioException("pessoa nao encontrada"));
    }
    
    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        Contato contatoLista = buscaIdContato(id);
        contatoLista.setTipoContato(contatoAtualizar.getTipoContato());
        contatoLista.setNumero(contatoAtualizar.getNumero());
        contatoLista.setDescricao(contatoAtualizar.getDescricao());
        return contatoLista;
    }
    
    public void delete(Integer id) throws Exception {
        Contato contatoLista = buscaIdContato(id);
        contatoRepository.listar().remove(contatoLista);
    }
    
    public Contato buscaIdContato (Integer id) throws RegraDeNegocioException {
     return contatoRepository.listar().stream()
             .filter(contato -> contato.getIdContato().equals(id))
             .findFirst()
             .orElseThrow(()-> new RegraDeNegocioException("Contato nao encontrado"));
    }
}
