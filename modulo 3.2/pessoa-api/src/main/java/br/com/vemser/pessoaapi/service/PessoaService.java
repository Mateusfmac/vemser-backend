package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.*;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
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
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        emailService.createSimpleMessagePessoa(pessoaEntity);
        return objectMapper.convertValue(pessoaRepository.save(pessoaEntity), PessoaDTO.class);
    }
    
    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().stream().map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .collect(Collectors.toList());
    }
    
    public PessoaDTO buscaPorNome(String nome) throws RegraDeNegocioException {
        return pessoaRepository.findAll().stream()
                .filter(pessoaEntity -> pessoaEntity.getNome().toUpperCase().contains(nome.toUpperCase()))
                .findFirst()
                .map(nomeBusca -> objectMapper.convertValue(nomeBusca, PessoaDTO.class))
                .orElseThrow(() -> new RegraDeNegocioException("Nome nao encontrado"));
    }
    
    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        PessoaEntity pessoaEntityRecuperada = buscaIdPessoa(id);
        log.info("atualizando pessoa");
        pessoaEntityRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaEntityRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaEntityRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        emailService.updateSimpleMessagePessoa(pessoaEntityRecuperada);
        pessoaRepository.save(pessoaEntityRecuperada);
        return objectMapper.convertValue(pessoaAtualizar, PessoaDTO.class);
    }
    
    public void delete(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaEntityRecuperada = buscaIdPessoa(id);
        pessoaRepository.delete(pessoaEntityRecuperada);
    }
    
    public PessoaDTO convertToDTO(PessoaEntity pessoaEntity) {
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        return pessoaDTO;
    }
    
    public PessoaEntity convertToEntity(PessoaDTO pessoaDTO) {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaDTO, PessoaEntity.class);
        return pessoaEntity;
    }
    
    public PessoaEntity buscaIdPessoa(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("id Pessoa não econtrado"));
    }
    
    public List<PessoaDTO> listarPessoaPets(Integer id) {
        if (id == null) {
            return pessoaRepository.findAll()
                    .stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertToDTO(pessoaEntity);
                        pessoaDTO.setPetDTO(objectMapper.convertValue(pessoaEntity.getPet(), PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findById(id)
                    .stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertToDTO(pessoaEntity);
                        pessoaDTO.setPetDTO(
                                objectMapper.convertValue(pessoaEntity.getPet(), PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        }
    }
    
    public List<PessoaDTO> listarPessoaContato(Integer id) {
        if (id != null) {
            return pessoaRepository.findById(id).stream().map(pessoaEntity -> {
                PessoaDTO pessoaDTO = convertToDTO(pessoaEntity);
                pessoaDTO.setContatoDTOList(pessoaEntity.getContatos()
                        .stream()
                        .map(contatoEntity ->
                                objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                        .toList());
                return pessoaDTO;
            }).toList();
        } else {
            return pessoaRepository.findAll()
                    .stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertToDTO(pessoaEntity);
                        pessoaDTO.setContatoDTOList(pessoaEntity.getContatos()
                                .stream()
                                .map(contatoEntity ->
                                        objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();
        }
    }
    
    public List<PessoaDTO> listarPessoaEndereco(Integer id) {
        if (id == null) {
            return pessoaRepository.findAll()
                    .stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertToDTO(pessoaEntity);
                        pessoaDTO.setEnderecoDTOList(pessoaEntity.getEnderecos()
                                .stream()
                                .map(enderecoEntity ->
                                        objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findById(id)
                    .stream()
                    .map(pessoaEntity -> {
                        PessoaDTO pessoaDTO = convertToDTO(pessoaEntity);
                        pessoaDTO.setEnderecoDTOList(pessoaEntity.getEnderecos()
                                .stream()
                                .map(enderecoEntity ->
                                        objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();
        }
    }
    
    public List<PessoaDTO> tudoJuntoEMisturado(Integer id) {
        return pessoaRepository.findById(id)
                .stream()
                .map(pessoaEntity -> {
                    PessoaDTO pessoaDTO = convertToDTO(pessoaEntity);
                    pessoaDTO.setEnderecoDTOList(pessoaEntity.getEnderecos()
                            .stream()
                            .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                            .toList());
                    pessoaDTO.setContatoDTOList(pessoaEntity.getContatos()
                            .stream()
                            .map(contatoEntity ->
                                    objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                            .toList());
                    pessoaDTO.setPetDTO(
                            objectMapper.convertValue(pessoaEntity.getPet(), PetDTO.class));
                    return pessoaDTO;
                }).toList();
    }
    
    public List<RelatorioPessoaDTO> relatorioPessoa(Integer idPessoa) {
        return pessoaRepository.relatorioPessoa(idPessoa);
    }
    
    public PessoaEntity salvar(PessoaEntity pessoaEntity) {
        return this.pessoaRepository.save(pessoaEntity);
    }
}
