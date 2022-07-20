package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoPet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetCreateDTO {
    @Schema(  description = "Id da pessoa")
    @NotNull
    private Integer idPessoa;
    
    @Schema(description = "nome do pet")
    @NotBlank
    @Size(max = 250, message = "deve conter max de 250 caracteres")
    private String nome;
    
    @Schema(description = "tipo do pet, CACHORRO, GALINHA, COBRA")
    private TipoPet tipoPet;
}
