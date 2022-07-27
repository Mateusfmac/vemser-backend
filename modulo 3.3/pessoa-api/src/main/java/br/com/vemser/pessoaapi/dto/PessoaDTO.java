package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO extends PessoaCreateDTO {
    @Schema(description = "ID da pessoa")
    private Integer idPessoa;
    
    @Schema(description = "Pet da pessoa")
    private PetDTO petDTO;
    
    @Schema(description = "Lista de endereco da pessoa")
    private List<EnderecoDTO> enderecoDTOList;
    
    @Schema(description = "Lista de contato da pessoa")
    private List<ContatoDTO> contatoDTOList;
    
}
