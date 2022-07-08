package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;
    
    @PostMapping("/{idPessoa}")
    public Endereco criar(@PathVariable("idPessoa") Integer id, @RequestBody Endereco endereco) throws RegraDeNegocioException {
        return enderecoService.criar(id, endereco);
    }
    
    @GetMapping
    public List<Endereco> listar() {
        return enderecoService.listar();
    }
    
    @GetMapping("/{idEndereco}")
    public Endereco listarIdEndereco(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException{
        return enderecoService.buscarPorId(id);
    }
    
    @GetMapping("/{idPessoa}/pessoa")
     public Endereco listarIdPessoa(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        return enderecoService.listarIdPessoa(id);
    }
    
    @PutMapping("/{idEndereco}")
    public Endereco update(@PathVariable("idEndereco") Integer id, @RequestBody Endereco endereco) throws RegraDeNegocioException {
        return enderecoService.update(id, endereco);
    }
    
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        enderecoService.delete(id);
    }
}
