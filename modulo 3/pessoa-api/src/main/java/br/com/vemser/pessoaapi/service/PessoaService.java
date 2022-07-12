package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.java.Log;

import java.util.List;
import java.util.stream.Collectors;

@Log
@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private EmailService emailService;
    
    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        Pessoa pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, Pessoa.class);
        emailService.createSimpleMessagePessoa(pessoaEntity);
        return objectMapper.convertValue(pessoaRepository.create(pessoaEntity), PessoaDTO.class);
    }
    
    public List<PessoaDTO> list() {
        return pessoaRepository.list().stream().map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }
    
    public PessoaDTO buscaPorNome(String nome) throws RegraDeNegocioException {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .findFirst()
                .map(nomeBusca -> objectMapper.convertValue(nomeBusca, PessoaDTO.class))
                .orElseThrow(() -> new RegraDeNegocioException("Nome nao encontrado"));
    }
    
    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = buscaIdPessoa(id);
        log.info("atualizando pessoa");
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        emailService.updateSimpleMessagePessoa(pessoaRecuperada);
        return objectMapper.convertValue(pessoaAtualizar, PessoaDTO.class);
    }
    
    public void delete(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = buscaIdPessoa(id);
        pessoaRepository.list().remove(pessoaRecuperada);
    }
    
    public PessoaDTO convertToDTO(Pessoa pessoa) {
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
        return pessoaDTO;
    }
    
    public Pessoa convertToEntity(PessoaDTO pessoaDTO) {
        Pessoa pessoa = objectMapper.convertValue(pessoaDTO, Pessoa.class);
        return pessoa;
    }
    
    public Pessoa buscaIdPessoa(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("id Pessoa não econtrado"));
    }
}
