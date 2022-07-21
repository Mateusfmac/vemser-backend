package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.vemser.pessoaapi.dto.PetDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.PetEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    PetRepository petRepository;
    @Autowired
    PessoaService pessoaService;
    
    public PetDTO criar(PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        PetEntity petEntity = convertToEntity(petCreateDTO);
        petEntity.setPessoa(pessoaService.buscaIdPessoa(petEntity.getIdPessoa()));
        petRepository.save(petEntity);
        return convertToDTO(petEntity);
    }
    
    public List<PetDTO> listar() throws RegraDeNegocioException {
        return petRepository.findAll()
                .stream()
                .map(petEntity -> objectMapper.convertValue(petEntity, PetDTO.class))
                .collect(Collectors.toList());
    }
    
    public PetDTO atualizar(Integer id, PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        PetEntity petEntityRecuperado = findById(id);
        PessoaEntity pessoaRecuparada = pessoaService.buscaIdPessoa(petCreateDTO.getIdPessoa());
        petRepository.save(petEntityRecuperado);
        petEntityRecuperado.setIdPessoa(petCreateDTO.getIdPessoa());
        petEntityRecuperado.setNome(petCreateDTO.getNome());
        petEntityRecuperado.setTipoPet(petCreateDTO.getTipoPet());
        petEntityRecuperado.setPessoa(pessoaRecuparada);
        pessoaService.salvar(pessoaRecuparada);
        return convertToDTO(petEntityRecuperado);
    }
    
    public void deletar(Integer id) throws RegraDeNegocioException {
        PetEntity petEntity = findById(id);
        petRepository.delete(petEntity);
    }
    
    public PetEntity convertToEntity (PetCreateDTO petCreateDTO) {
        PetEntity petEntity = objectMapper.convertValue(petCreateDTO, PetEntity.class);
        return petEntity;
    }
    public PetDTO convertToDTO (PetEntity petEntity){
        PetDTO petDTO = objectMapper.convertValue(petEntity, PetDTO.class);
        return petDTO;
    }
    
    public PetEntity findById(Integer id) throws RegraDeNegocioException {
        return petRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Id nao encontrado"));
    }
}
