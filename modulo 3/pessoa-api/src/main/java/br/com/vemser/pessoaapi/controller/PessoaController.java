package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.config.PropertieReader;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa") //localhost:8080/pessoa
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
    public String hello() {
        return propertieReader.getAmbiente();
    }
    
    //falta by name
    
    @PostMapping //localhost:8080/pessoa
    public Pessoa create(@RequestBody Pessoa pessoa) throws Exception {
        return pessoaService.create(pessoa);
    }
    
    @GetMapping //localhost:8080/pessoa
    public List<Pessoa> list() {
        return pessoaService.list();
    }
    
    @PutMapping("/{idPessoa}") //localhost:8080/pessoa/1000
    public Pessoa update(@PathVariable("idPessoa") Integer id,
                         @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }
    
    @DeleteMapping("/{idPessoa}") //localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}
