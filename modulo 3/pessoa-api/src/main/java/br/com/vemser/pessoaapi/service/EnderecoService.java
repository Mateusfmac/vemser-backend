package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.Pessoa;
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
        Pessoa pessoaEncontrada = pessoaService.buscaIdPessoa(id);
        enderecoCreateDTO.setIdPessoa(id);
        Endereco enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, Endereco.class);
        emailService.sendEmailCreate(pessoaService.convertToDTO(pessoaEncontrada), convertToDTO(enderecoEntity));
        return convertToDTO(enderecoRepository.criar(enderecoEntity));
    }
    
    public List<EnderecoDTO> listar() {
        return enderecoRepository.listar().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }
    
   public EnderecoDTO listarIdEndereco(Integer id) throws RegraDeNegocioException{
       buscarPorId(id);
        return enderecoRepository.listar().stream()
               .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .orElseThrow(()-> new RegraDeNegocioException("pessoa nao encontrada"));
   }
    
    public EnderecoDTO listarIdPessoa(Integer id) throws RegraDeNegocioException {
        return enderecoRepository.listar().stream()
                .filter(idPes -> idPes.getIdPessoa().equals(id))
                .findFirst()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .orElseThrow(()-> new RegraDeNegocioException("pessoa nao encontrada"));
    }
    
    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        Endereco enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, Endereco.class);
        Endereco novoEndereco = buscarPorId(id);
        novoEndereco.setIdPessoa(enderecoEntity.getIdPessoa());
        novoEndereco.setTipo(enderecoEntity.getTipo());
        novoEndereco.setLogradouro(enderecoEntity.getLogradouro());
        novoEndereco.setNumero(enderecoEntity.getNumero());
        novoEndereco.setComplemento(enderecoEntity.getComplemento());
        novoEndereco.setCep(enderecoEntity.getCep());
        novoEndereco.setCidade(enderecoEntity.getCidade());
        novoEndereco.setEstado(enderecoEntity.getEstado());
        novoEndereco.setPais(enderecoEntity.getPais());
        Pessoa pessoaEncontrada = pessoaService.buscaIdPessoa(enderecoEntity.getIdPessoa());
        emailService.sendEmailUpdate(pessoaService.convertToDTO(pessoaEncontrada), convertToDTO(novoEndereco));
        return convertToDTO(novoEndereco);
    }
    
    public void delete(Integer id) throws RegraDeNegocioException {
        emailService.sendEmailDelete(pessoaService.buscaIdPessoa(id), convertToEntity(listarIdEndereco(id)));
        enderecoRepository.listar().remove(buscarPorId(id));
    }
    
    //conversao
    public EnderecoDTO convertToDTO(Endereco endereco) {
        EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
        return enderecoDTO;
    }
    
    //conversao
    public Endereco convertToEntity(EnderecoDTO enderecoDTO) {
        Endereco endereco = objectMapper.convertValue(enderecoDTO, Endereco.class);
        return endereco;
    }
    
    public Endereco buscarPorId(Integer id) throws RegraDeNegocioException{
        Endereco novoEndereco = enderecoRepository.listar().stream()
                .filter(end -> end.getIdEndereco().equals(id))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("id endereco nao encontrado"));
        return novoEndereco;
    }
}
