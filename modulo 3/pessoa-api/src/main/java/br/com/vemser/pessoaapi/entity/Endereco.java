package br.com.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {
    private Integer idEndereco;
    private Integer idPessoa;
    
    @NotNull(message = "insira um tipo de endereco: RESIDENCIAL ou COMERCIAL")
    private TipoEndereco tipo;
    
    @NotBlank
    @Size(max = 250, message = "logradouro nao pode conter mais que 250 caracteres")
    private String logradouro;
    
    @NotNull
    @Min(value = 0, message = "numero nao pode ser vazio")
    private Integer numero;
    private String complemento;
    
    @NotNull
    @NotBlank
    @Size(max = 8, message = "cep invalido, nao deve conter mais que 8 numeros")
    private String cep;
    
    @NotNull
    @NotBlank
    @Size(max = 250, message = "cidade nao pode conter mais que 250 caracteres")
    private String cidade;
    
    @NotNull
    private String estado;
    
    @NotNull
    private String pais;
}
