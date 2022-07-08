package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.config.PropertieReader;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") //localhost:8080/pessoa
@Validated
public class PessoaController {
    @Autowired //MODELO ANTIGO
    private PessoaService pessoaService;
    @Autowired
    private PropertieReader propertieReader;
    
    //MODELO ATUAL
    //private final PessoaService pessoaService;
    
    //MODELO ATUAL
    //public PessoaController(PessoaService pessoaService) {
    //this.pessoaService =  pessoaService;
    //}
    @GetMapping("/ambiente")
    public String getAmbiente() {
        return propertieReader.getAmbiente();
    }
    
    @PostMapping //localhost:8080/pessoa
    public ResponseEntity<Pessoa> create(@RequestBody @Valid Pessoa pessoa) throws RegraDeNegocioException {
        return new ResponseEntity(pessoaService.create(pessoa), HttpStatus.OK);
    }
    
    @GetMapping //localhost:8080/pessoa
    public List<Pessoa> list() {
        return pessoaService.list();
    }
    
    @GetMapping("/pornome")
    public Pessoa buscaPorNome(@RequestParam("nome") String nome) throws RegraDeNegocioException {
        return pessoaService.buscaPorNome(nome);
    }
    
    @PutMapping("/{idPessoa}") //localhost:8080/pessoa/1000
    public ResponseEntity<Pessoa> update(@PathVariable("idPessoa") Integer id,
                         @RequestBody @Valid Pessoa pessoaAtualizar) throws Exception {
        return new ResponseEntity(pessoaService.update(id, pessoaAtualizar), HttpStatus.OK);
    }
    
    @DeleteMapping("/{idPessoa}") //localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}
