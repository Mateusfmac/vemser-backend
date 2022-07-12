package br.com.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contato {
    //validacoes nos DTO
    private Integer idContato;
    private Integer idPessoa;
    private String tipoContato;
    private String numero;
    private String descricao;
}
