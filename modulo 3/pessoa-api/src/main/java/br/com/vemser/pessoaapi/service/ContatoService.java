package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
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
    private PessoaRepository pessoaRepository;
    
    public Contato create(Integer id, Contato contato) throws Exception {
        Pessoa pessoa = pessoaRepository.list().stream()
                .filter(pes -> pes.getIdPessoa().equals(id))
                .findFirst().orElseThrow(() -> new Exception("pessoa nao encontrada"));
        return contatoRepository.create(contato);
    }
    
    public List<Contato> listar() throws Exception {
        return contatoRepository.listar();
    }
    
    public Contato contatoIdPessoa(Integer id) throws Exception {
        return contatoRepository.listar().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .findFirst().orElseThrow(() -> new Exception("id nao encontrado"));
    }
    
    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        Contato contatoLista = contatoRepository.listar().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato nao encontrado"));
        contatoLista.setTipoContato(contatoAtualizar.getTipoContato());
        contatoLista.setNumero(contatoAtualizar.getNumero());
        contatoLista.setDescricao(contatoAtualizar.getDescricao());
        return contatoLista;
    }
    
    public void delete(Integer id) throws Exception {
        contatoRepository.delete(id);
    }
}
