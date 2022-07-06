package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/contato")
public class ContatoController {
    
    private ContatoService contatoService;
    
    public ContatoController() {
        contatoService = new ContatoService();
    }
    
    @PostMapping("/{idPessoa}")
    public Contato create(@PathVariable("idPessoa")Integer id, @RequestBody Contato contato) throws Exception {
        return contatoService.create(id, contato);
    }
    
    @GetMapping
    public List<Contato> listar() throws Exception{
        return contatoService.listar();
    }
    
    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato")Integer id, @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }
    
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato")Integer id) throws Exception {
        contatoService.delete(id);
    }
    
    @GetMapping("/{idPessoa}")
    public List<Contato> contatoIdPessoa(@PathVariable("idPessoa") Integer id) {
        return contatoService.contatoIdPessoa(id);
    }
}
