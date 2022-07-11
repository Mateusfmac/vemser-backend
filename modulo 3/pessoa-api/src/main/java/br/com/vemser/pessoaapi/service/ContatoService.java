package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;
    
    @Autowired
    private PessoaService pessoaService;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    public ContatoDTO create(Integer id, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        pessoaService.buscaIdPessoa(id);
        contatoCreateDTO.setIdPessoa(id);
        Contato contato = objectMapper.convertValue(contatoCreateDTO, Contato.class);
        return objectMapper.convertValue(contatoRepository.create(contato), ContatoDTO.class);
    }
    
    public List<ContatoDTO> listar() {
        return contatoRepository.listar().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }
    
    public ContatoDTO listarIdPessoa(Integer id) throws RegraDeNegocioException {
        return contatoRepository.listar().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .findFirst()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .orElseThrow(() -> new RegraDeNegocioException("pessoa nao encontrada"));
    }
    
    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException {
        Contato contatoLista = buscaIdContato(id);
        contatoLista.setTipoContato(contatoAtualizar.getTipoContato());
        contatoLista.setNumero(contatoAtualizar.getNumero());
        contatoLista.setDescricao(contatoAtualizar.getDescricao());
        return objectMapper.convertValue(contatoAtualizar, ContatoDTO.class);
    }
    
    public void delete(Integer id) throws RegraDeNegocioException {
        Contato contatoLista = buscaIdContato(id);
        contatoRepository.listar().remove(contatoLista);
    }
    
    public Contato buscaIdContato(Integer id) throws RegraDeNegocioException {
        return contatoRepository.listar().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato nao encontrado"));
    }
}
