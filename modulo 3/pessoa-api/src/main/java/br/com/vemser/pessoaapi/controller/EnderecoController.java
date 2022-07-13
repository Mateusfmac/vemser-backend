package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.EnderecoService;
import freemarker.template.TemplateException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    
    @Operation(summary = "Cria endereço", description = "Cria um endereço no banco caso a pessoa exista")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço criado"),
                    @ApiResponse(responseCode = "400", description = "Pessoa não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> criar(@PathVariable("idPessoa") Integer id, @RequestBody @Valid EnderecoCreateDTO endereco) throws RegraDeNegocioException, TemplateException, IOException {
        return new ResponseEntity(enderecoService.criar(id, endereco), HttpStatus.OK);
    }
    
    @Operation(summary = "Lista Endereços", description = "Lista todos os Endereços")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Listar Endereços"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<EnderecoDTO> listar() {
        return enderecoService.listar();
    }
    
    @Operation(summary = "Buscar Endereço por ID", description = "Busca Endereço pelo seu ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Listar Endereço"),
                    @ApiResponse(responseCode = "400", description = "Enreço não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idEndereco}")
    public EnderecoDTO listarIdEndereco(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException{
        return enderecoService.listarIdEndereco(id);
    }
    
    @Operation(summary = "Busca por Id Pessoa", description = "Busca endereços pelo ID da pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Lista endereço por ID da pessoa"),
                    @ApiResponse(responseCode = "400", description = "Pessoa não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}/pessoa")
     public EnderecoDTO listarIdPessoa(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        return enderecoService.listarIdPessoa(id);
    }
    
    @Operation(summary = "Atualizar Endereço", description = "Atualizar endereço pelo ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço Atualizado"),
                    @ApiResponse(responseCode = "400", description = "Endereço não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id, @RequestBody @Valid EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        return new ResponseEntity(enderecoService.update(id, endereco), HttpStatus.OK);
    }
    
    @Operation(summary = "Deleta Endereço", description = "Deleta endereço pelo seu ID")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Endereço criado"),
                    @ApiResponse(responseCode = "400", description = "Endereço não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        enderecoService.delete(id);
    }
}
