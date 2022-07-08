package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
public class ContatoController {
    @Autowired
    private ContatoService contatoService;
    
    public ContatoController() {
        //contatoService = new ContatoService();
    }
    
    @PostMapping("/{idPessoa}")
    public ResponseEntity<Contato> create(@PathVariable("idPessoa") Integer id, @RequestBody @Valid Contato contato) throws RegraDeNegocioException {
        return new ResponseEntity(contatoService.create(id, contato), HttpStatus.OK);
    }
    
    @GetMapping
    public List<Contato> listar() {
        return contatoService.listar();
    }
    
    @PutMapping("/{idContato}")
    public ResponseEntity<Contato> update(@PathVariable("idContato") Integer id, @RequestBody @Valid Contato contatoAtualizar) throws RegraDeNegocioException {
        return new  ResponseEntity(contatoService.update(id, contatoAtualizar), HttpStatus.OK);
    }
    
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        contatoService.delete(id);
    }
    
    @GetMapping("/{idPessoa}")
    public Contato contatoIdPessoa(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        return contatoService.listarIdPessoa(id);
    }
}
