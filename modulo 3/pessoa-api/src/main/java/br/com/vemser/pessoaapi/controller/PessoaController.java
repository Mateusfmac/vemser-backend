package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa") //localhost:8080/pessoa
public class PessoaController {
    
    private PessoaService pessoaService;
    
    public PessoaController() {
        pessoaService = new PessoaService();
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    
    //falta by name
    
    @PostMapping //localhost:8080/pessoa
    public Pessoa create(@RequestBody Pessoa pessoa) {
        return pessoaService.create(pessoa);
    }
    
    @GetMapping //localhost:8080/pessoa
    public List<Pessoa> list() {
        return pessoaService.list();
    }
    
    @PutMapping("/{idPessoa}") //localhost:8080/pessoa/1000
    public Pessoa update(@PathVariable("idPessoa") Integer id,
                         @RequestBody Pessoa pessoaAtualizar) throws Exception{
       return pessoaService.update(id, pessoaAtualizar);
    }
    
    @DeleteMapping("/{idPessoa}") //localhost:8080/pessoa/10
    public void delete (@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}
