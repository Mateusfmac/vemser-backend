package br.com.vemser.pessoaapi.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContatoDTO extends ContatoCreateDTO{
    private Integer idContato;
}
