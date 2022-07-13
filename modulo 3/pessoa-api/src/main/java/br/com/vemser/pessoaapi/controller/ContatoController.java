package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    
    @Operation(summary = "Cria Contato", description = "Cria um contato no banco caso a pessoa exista")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato criado"),
                    @ApiResponse(responseCode = "400", description = "Pessoa não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer id, @RequestBody @Valid ContatoCreateDTO contato) throws RegraDeNegocioException {
        return new ResponseEntity(contatoService.create(id, contato), HttpStatus.OK);
    }
    
    @Operation(summary = "Lista contatos", description = "Lista todos os contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Listando Contatos"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<ContatoDTO> listar() {
        return contatoService.listar();
    }
    
    @Operation(summary = "Atualizar contato", description = "Atualiza um Contato do banco caso exista")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato Atualizado"),
                    @ApiResponse(responseCode = "400", description = "Contato não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id, @RequestBody @Valid ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException {
        return new  ResponseEntity(contatoService.update(id, contatoAtualizar), HttpStatus.OK);
    }
    
    @Operation(summary = "Delta contato", description = "Deleta um contato no banco caso exista")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato Deletado"),
                    @ApiResponse(responseCode = "400", description = "Contato não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        contatoService.delete(id);
    }
    
    @Operation(summary = "Busca contato ID pessoa", description = "Busca um contato no banco pelo ID da pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Contato Encontrado"),
                    @ApiResponse(responseCode = "400", description = "Pessoa não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}")
    public ContatoDTO contatoIdPessoa(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        return contatoService.listarIdPessoa(id);
    }
}
