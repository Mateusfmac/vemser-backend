package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO extends PessoaCreateDTO {
    @Schema(description = "ID da pessoa")
    private Integer idPessoa;
    @Schema(description = "pet")
    private PetDTO petDTO;
}
