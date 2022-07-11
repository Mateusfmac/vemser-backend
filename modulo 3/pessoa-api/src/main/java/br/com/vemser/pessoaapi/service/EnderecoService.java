package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
    public EnderecoDTO criar(Integer id, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        pessoaService.buscaIdPessoa(id);
        enderecoCreateDTO.setIdPessoa(id);
        Endereco enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, Endereco.class);
        return objectMapper.convertValue(enderecoRepository.criar(enderecoEntity), EnderecoDTO.class);
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
        Endereco novoEndereco = buscarPorId(id);
        novoEndereco.setTipo(enderecoCreateDTO.getTipo());
        novoEndereco.setLogradouro(enderecoCreateDTO.getLogradouro());
        novoEndereco.setNumero(enderecoCreateDTO.getNumero());
        novoEndereco.setComplemento(enderecoCreateDTO.getComplemento());
        novoEndereco.setCep(enderecoCreateDTO.getCep());
        novoEndereco.setCidade(enderecoCreateDTO.getCidade());
        novoEndereco.setEstado(enderecoCreateDTO.getEstado());
        novoEndereco.setPais(enderecoCreateDTO.getPais());
        return objectMapper.convertValue(enderecoCreateDTO, EnderecoDTO.class);
    }
    
    public void delete(Integer id) throws RegraDeNegocioException {
        enderecoRepository.listar().remove(buscarPorId(id));
    }
    
    public Endereco buscarPorId(Integer id) throws RegraDeNegocioException{
        Endereco novoEndereco = enderecoRepository.listar().stream()
                .filter(end -> end.getIdEndereco().equals(id))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("id endereco nao encontrado"));
        return novoEndereco;
    }
}
