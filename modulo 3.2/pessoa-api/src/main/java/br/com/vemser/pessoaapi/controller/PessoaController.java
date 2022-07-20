package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.config.PropertieReader;
import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import br.com.vemser.pessoaapi.service.EmailService;
import br.com.vemser.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Date;
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
    
    @Autowired
    private PessoaRepository pessoaRepository;
    
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
    
    
    @Operation(summary = "criar pessoas", description = "Cria uma pessoa no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cria uma pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping //localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        return new ResponseEntity(pessoaService.create(pessoa), HttpStatus.OK);
    }
    /*@GetMapping("/email")
    public String email() {
      emailService.sendSimpleMessage();
      return "Enviado Email..";
    }*/
    
    @Operation(summary = "listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping //localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }
    
    @Operation(summary = "busca pessoas por nome", description = "Busca uma pessoa no banco pelo nome")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Busca pessoa por nome"),
                    @ApiResponse(responseCode = "400", description = "Pessoa não encontrada"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/pornome")
    public PessoaDTO buscaPorNome(@RequestParam("nome") String nome) throws RegraDeNegocioException {
        return pessoaService.buscaPorNome(nome);
    }
    
    @Operation(summary = "Atualizar pessoa", description = "Atualiza uma pessoa no banco pelo ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Atualiza uma pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}") //localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                         @RequestBody @Valid PessoaCreateDTO pessoaAtualizar) throws RegraDeNegocioException {
        return new ResponseEntity(pessoaService.update(id, pessoaAtualizar), HttpStatus.OK);
    }
    
    @Operation(summary = "Deletar pessoa", description = "Deleta uma pessoa no banco pelo ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Deleta uma pessoa"),
                    @ApiResponse(responseCode = "400", description = "ID pessoa não encontrada"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPessoa}") //localhost:8080/pessoa/10
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        pessoaService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    //exercicios
    @GetMapping("/{nome}")
    public ResponseEntity<PessoaEntity> buscarNomePessoa(@PathVariable("nome") String nome) throws RegraDeNegocioException{
        return new ResponseEntity(pessoaRepository.findByNomeContainsIgnoreCase(nome), HttpStatus.OK);
    }
    
    @GetMapping("/cpf")
    public ResponseEntity<PessoaEntity> buscarCpfPessoa(@RequestParam("cpf") String cpf) throws RegraDeNegocioException {
       return new ResponseEntity(pessoaRepository.findByCpf(cpf), HttpStatus.OK);
    }
    
   /* @GetMapping("dataNascimento")
    public ResponseEntity<PessoaEntity> buscarDataNascEntre(@RequestParam("dataNascimento") Date inicio, Date fim) throws RegraDeNegocioException{
        return new ResponseEntity(pessoaRepository.findByNascimentoBetween(inicio, fim), HttpStatus.OK);
    }*/
}
