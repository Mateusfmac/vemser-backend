package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContatoDTO extends ContatoCreateDTO{
    @Schema(description = "ID contato")
    private Integer idContato;
}
