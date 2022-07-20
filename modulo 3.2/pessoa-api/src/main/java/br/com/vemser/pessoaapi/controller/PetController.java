package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.vemser.pessoaapi.dto.PetDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/pet")
@RestController
@Validated
public class PetController {
    @Autowired
    PetService petService;
    
    @PostMapping
    public ResponseEntity<PetDTO> criar(@RequestBody @Valid PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
    return new ResponseEntity(petService.criar(petCreateDTO), HttpStatus.OK);
    }
    
    @GetMapping
    public List<PetDTO> listar() throws RegraDeNegocioException {
        return petService.listar();
    }
    
    @PutMapping("/{idPet}")
    public ResponseEntity<PetDTO> atualizar(@PathVariable("idPet") @RequestBody @Valid Integer id, PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        return new ResponseEntity<>(petService.atualizar(id, petCreateDTO), HttpStatus.OK);
    }
    
    @DeleteMapping("/{idPet}")
    public void deletar(Integer id) throws RegraDeNegocioException {
        petService.deletar(id);
    }
}
