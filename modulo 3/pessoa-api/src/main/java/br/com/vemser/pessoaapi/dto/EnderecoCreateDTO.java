package br.com.vemser.pessoaapi.dto;

 import br.com.vemser.pessoaapi.entity.TipoEndereco;
 import io.swagger.v3.oas.annotations.media.Schema;
 import lombok.*;
 import javax.validation.constraints.Min;
 import javax.validation.constraints.NotBlank;
 import javax.validation.constraints.NotNull;
 import javax.validation.constraints.Size;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCreateDTO {
    
    private Integer idPessoa;
    
    @Schema(description = "Tipo do endereço")
    @NotNull(message = "insira um tipo de endereco: RESIDENCIAL ou COMERCIAL")
    private TipoEndereco tipo;
    
    @Schema(description = "Nome da Rua")
    @NotBlank
    @Size(max = 250, message = "logradouro nao pode conter mais que 250 caracteres")
    private String logradouro;
    
    @Schema(description = "Numero do complemento")
    @NotNull
    @Min(value = 0, message = "numero nao pode ser vazio")
    private Integer numero;
    
    @Schema(description = "Complemento")
    private String complemento;
    
    @Schema(description = "CEP, somente os numeros")
    @NotNull
    @NotBlank
    @Size(max = 8, message = "cep invalido, nao deve conter mais que 8 numeros")
    private String cep;
    
    @Schema(description = "Nome da Cidade")
    @NotNull
    @NotBlank
    @Size(max = 250, message = "cidade nao pode conter mais que 250 caracteres")
    private String cidade;
    
    @Schema(description = "Nome do Estado")
    @NotNull
    private String estado;
    
    @Schema(description = "Nome do País")
    @NotNull
    private String pais;
}
