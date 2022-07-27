package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoCreateDTO {
    
    @Schema(description = "Id da pessoa")
    private Integer idPessoa;
    
    @Schema(description = "Tipo de contato COMERCIAL/RESIDENCIAL")
    @NotNull(message = "insira um tipo de contato valido")
    private String tipoContato;
    
    @Schema(description = "Numero para contato")
    @NotNull
    @Size(max = 13, message = "insira um numero com ate 13 digitos")
    private String numero;
    
    @Schema(description = "Descriçao do contato")
    @NotBlank
    @NotNull
    private String descricao;
}
