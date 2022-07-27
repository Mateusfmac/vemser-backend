package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.ContatoEntity;
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
        ContatoEntity contatoEntity = objectMapper.convertValue(contatoCreateDTO, ContatoEntity.class);
        contatoRepository.save(contatoEntity);
        return objectMapper.convertValue(contatoEntity, ContatoDTO.class);
    }
    
    public List<ContatoDTO> listar() {
        return contatoRepository.findAll().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }
    
    public ContatoDTO listarIdPessoa(Integer id) throws RegraDeNegocioException {
        return contatoRepository.findAll().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .findFirst()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .orElseThrow(() -> new RegraDeNegocioException("pessoa nao encontrada"));
    }
    
    public ContatoDTO update(Integer id, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        ContatoEntity contatoEntityLista = buscaIdContato(id);
        contatoEntityLista.setIdPessoa(contatoCreateDTO.getIdPessoa());
        contatoEntityLista.setTipoContato(contatoCreateDTO.getTipoContato());
        contatoEntityLista.setNumero(contatoCreateDTO.getNumero());
        contatoEntityLista.setDescricao(contatoCreateDTO.getDescricao());
        contatoRepository.save(contatoEntityLista);
        return objectMapper.convertValue(contatoEntityLista, ContatoDTO.class);
    }
    
    public void delete(Integer id) throws RegraDeNegocioException {
        ContatoEntity contatoEntityLista = buscaIdContato(id);
        contatoRepository.delete(contatoEntityLista);
    }
    
    public ContatoEntity buscaIdContato(Integer id) throws RegraDeNegocioException {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato nao encontrado"));
    }
}
