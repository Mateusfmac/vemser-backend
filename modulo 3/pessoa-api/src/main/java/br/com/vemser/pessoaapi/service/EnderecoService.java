package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.Pessoa;
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
    private PessoaRepository pessoaRepository;
    
    public Endereco criar(Integer id, Endereco endereco) throws Exception {
        Pessoa pessoa = pessoaRepository.list().stream()
                .filter(pes -> pes.getIdPessoa().equals(id))
                .findFirst().orElseThrow(() -> new Exception("Pessoa nao encontrada"));
        return enderecoRepository.criar(endereco);
    }
    
    public List<Endereco> listar() {
        return enderecoRepository.listar();
    }
    
    public Endereco listarIdEndereco(Integer id) throws Exception {
        return enderecoRepository.listar().stream()
                .filter(idEnd -> idEnd.getIdEndereco().equals(id))
                .findFirst().orElseThrow(() -> new Exception("Endereco nao encontrado"));
    }
    
    public Endereco listarIdPessoa(Integer id) throws Exception {
        return enderecoRepository.listar().stream()
                .filter(idPes -> idPes.getIdPessoa().equals(id))
                .findFirst().orElseThrow(()-> new Exception("pessoa nao encontrada"));
    }
    
    public Endereco update(Integer id, Endereco endereco) throws Exception {
        Endereco novoEndereco = enderecoRepository.listar().stream()
                .filter(end -> end.getIdEndereco().equals(id))
                .findFirst().orElseThrow(() -> new Exception("Id nao encontrado"));
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
    
    public void delete(Integer id) throws Exception {
        enderecoRepository.delete(id);
    }
}
