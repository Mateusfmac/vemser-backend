package br.com.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contato {
    private Integer idContato;
    private Integer idPessoa;
    
    @NotNull(message = "insira um tipo de contato valido")
    private String tipoContato;
    
    @NotNull
    @Size(max = 13, message = "insira um numero com ate 13 digitos")
    private String numero;
    
    @NotBlank
    @NotNull
    private String descricao;
}
