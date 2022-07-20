package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Autowired
    private PessoaService pessoaService;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private EmailService emailService;
    
    public EnderecoDTO criar(Integer id, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException, TemplateException, IOException {
        PessoaEntity pessoaEntityEncontrada = pessoaService.buscaIdPessoa(id);
        enderecoCreateDTO.setIdPessoa(id);
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        enderecoRepository.save(enderecoEntity);
        EnderecoDTO enderecoDTO1 = convertToDTO(enderecoEntity);
        emailService.sendEmailCreate(pessoaService.convertToDTO(pessoaEntityEncontrada), enderecoDTO1);
        return enderecoDTO1;
    }
    
    public List<EnderecoDTO> listar() {
        return enderecoRepository.findAll().stream()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .collect(Collectors.toList());
    }
    
   public EnderecoDTO listarIdEndereco(Integer id) throws RegraDeNegocioException{
       buscarPorId(id);
        return enderecoRepository.findAll().stream()
               .filter(enderecoEntity -> enderecoEntity.getIdEndereco().equals(id))
                .findFirst()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .orElseThrow(()-> new RegraDeNegocioException("pessoa nao encontrada"));
   }
    
    public EnderecoDTO listarIdPessoa(Integer id) throws RegraDeNegocioException {
        return enderecoRepository.findAll().stream()
               // .filter(idPes -> idPes.getIdPessoa().equals(id))
                .findFirst()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .orElseThrow(()-> new RegraDeNegocioException("pessoa nao encontrada"));
    }
    
    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity novoEnderecoEntity = buscarPorId(id);
        //novoEnderecoEntity.setIdPessoa(enderecoEntity.getIdPessoa());
        novoEnderecoEntity.setTipo(enderecoEntity.getTipo());
        novoEnderecoEntity.setLogradouro(enderecoEntity.getLogradouro());
        novoEnderecoEntity.setNumero(enderecoEntity.getNumero());
        novoEnderecoEntity.setComplemento(enderecoEntity.getComplemento());
        novoEnderecoEntity.setCep(enderecoEntity.getCep());
        novoEnderecoEntity.setCidade(enderecoEntity.getCidade());
        novoEnderecoEntity.setEstado(enderecoEntity.getEstado());
        novoEnderecoEntity.setPais(enderecoEntity.getPais());
       // PessoaEntity pessoaEntityEncontrada = pessoaService.buscaIdPessoa(enderecoEntity.getIdPessoa());
        EnderecoDTO enderecoDTO = convertToDTO(novoEnderecoEntity);
       // emailService.sendEmailUpdate(pessoaService.convertToDTO(pessoaEntityEncontrada), enderecoDTO);
        enderecoRepository.save(novoEnderecoEntity);
        return enderecoDTO;
    }
    
    public void delete(Integer id) throws RegraDeNegocioException {
        emailService.sendEmailDelete(pessoaService.buscaIdPessoa(id), convertToEntity(listarIdEndereco(id)));
        enderecoRepository.delete(buscarPorId(id));
    }
    
    //conversao
    public EnderecoDTO convertToDTO(EnderecoEntity enderecoEntity) {
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        return enderecoDTO;
    }
    
    //conversao
    public EnderecoEntity convertToEntity(EnderecoDTO enderecoDTO) {
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoDTO, EnderecoEntity.class);
        return enderecoEntity;
    }
    
    public EnderecoEntity buscarPorId(Integer id) throws RegraDeNegocioException{
        return enderecoRepository.findById(id)
                .orElseThrow(()-> new RegraDeNegocioException("id nao encontrado"));
    }
}
