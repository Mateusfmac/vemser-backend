package br.com.vemser.pessoaapi.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO extends PessoaCreateDTO {
    private Integer idPessoa;
}
