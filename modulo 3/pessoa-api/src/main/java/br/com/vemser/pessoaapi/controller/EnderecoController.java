package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.EnderecoService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Validated
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;
    
    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> criar(@PathVariable("idPessoa") Integer id, @RequestBody @Valid EnderecoCreateDTO endereco) throws RegraDeNegocioException, TemplateException, IOException {
        return new ResponseEntity(enderecoService.criar(id, endereco), HttpStatus.OK);
    }
    
    @GetMapping
    public List<EnderecoDTO> listar() {
        return enderecoService.listar();
    }
    
    @GetMapping("/{idEndereco}")
    public EnderecoDTO listarIdEndereco(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException{
        return enderecoService.listarIdEndereco(id);
    }
    
    @GetMapping("/{idPessoa}/pessoa")
     public EnderecoDTO listarIdPessoa(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        return enderecoService.listarIdPessoa(id);
    }
    
    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id, @RequestBody @Valid EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        return new ResponseEntity(enderecoService.update(id, endereco), HttpStatus.OK);
    }
    
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        enderecoService.delete(id);
    }
}
