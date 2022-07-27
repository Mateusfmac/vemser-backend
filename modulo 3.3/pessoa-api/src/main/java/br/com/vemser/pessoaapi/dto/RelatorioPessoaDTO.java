package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RelatorioPessoaDTO {
    @Schema(description = "ID da pessoa")
    private Integer idPessoa;
    
    @Schema(description = "Nome da Pessoa")
    private String nome;
    
    @Schema(description = "email da pessoa")
    private String email;
    
    @Schema(description = "Numero para contato")
    private String numero;
    
    @Schema(description = "CEP, somente os numeros")
    private String cep;
    
    @Schema(description = "Nome da Cidade")
    private String cidade;
    
    @Schema(description = "Nome do Estado")
    private String estado;
    
    @Schema(description = "Nome do País")
    private String pais;
    
    @Schema(description = "nome do pet")
    private String nomePet;
}
