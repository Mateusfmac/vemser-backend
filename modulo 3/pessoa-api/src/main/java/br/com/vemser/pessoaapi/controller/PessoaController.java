package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.config.PropertieReader;
import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.EmailService;
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
    
    @Autowired
    private EmailService emailService;
    
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
    
    /*@GetMapping("/email")
    public String email() {
      emailService.sendSimpleMessage();
      return "Enviado Email..";
    }*/
    @PostMapping //localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        return new ResponseEntity(pessoaService.create(pessoa), HttpStatus.OK);
    }
    
    @GetMapping //localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }
    
    @GetMapping("/pornome")
    public PessoaDTO buscaPorNome(@RequestParam("nome") String nome) throws RegraDeNegocioException {
        return pessoaService.buscaPorNome(nome);
    }
    
    @PutMapping("/{idPessoa}") //localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                         @RequestBody @Valid PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        return new ResponseEntity(pessoaService.update(id, pessoaAtualizar), HttpStatus.OK);
    }
    
    @DeleteMapping("/{idPessoa}") //localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        pessoaService.delete(id);
    }
}
