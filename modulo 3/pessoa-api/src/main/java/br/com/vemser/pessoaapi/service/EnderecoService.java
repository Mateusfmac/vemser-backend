package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Autowired
    private PessoaService pessoaService;
    
    public Endereco criar(Integer id, Endereco endereco) throws RegraDeNegocioException {
        Pessoa pessoa = pessoaService.buscaIdPessoa(id);
        endereco.setIdPessoa(id);
        return enderecoRepository.criar(endereco);
    }
    
    public List<Endereco> listar() {
        return enderecoRepository.listar();
    }
    
    public Endereco listarIdPessoa(Integer id) throws RegraDeNegocioException {
        return enderecoRepository.listar().stream()
                .filter(idPes -> idPes.getIdPessoa().equals(id))
                .findFirst().orElseThrow(()-> new RegraDeNegocioException("pessoa nao encontrada"));
    }
    
    public Endereco update(Integer id, Endereco endereco) throws RegraDeNegocioException {
        Endereco novoEndereco = buscarPorId(id);
        novoEndereco.setTipo(endereco.getTipo());
        novoEndereco.setLogradouro(endereco.getLogradouro());
        novoEndereco.setNumero(endereco.getNumero());
        novoEndereco.setComplemento(endereco.getComplemento());
        novoEndereco.setCep(endereco.getCep());
        novoEndereco.setCidade(endereco.getCidade());
        novoEndereco.setEstado(endereco.getEstado());
        novoEndereco.setPais(endereco.getPais());
        return novoEndereco;
    }
    
    public void delete(Integer id) throws RegraDeNegocioException {
        Endereco endereco = buscarPorId(id);
        enderecoRepository.listar().remove(endereco);
    }
    
    public Endereco buscarPorId(Integer id) throws RegraDeNegocioException{
        Endereco novoEndereco = enderecoRepository.listar().stream()
                .filter(end -> end.getIdEndereco().equals(id))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("id endereco nao encontrado"));
        return novoEndereco;
    }
}
