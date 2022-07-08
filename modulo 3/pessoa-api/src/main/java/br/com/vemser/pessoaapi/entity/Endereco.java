package br.com.vemser.pessoaapi.entity;

import javax.validation.constraints.*;

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
    
    public Endereco(Integer idEndereco, Integer idPessoa, TipoEndereco tipo, String logradouro, Integer numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.idEndereco = idEndereco;
        this.idPessoa = idPessoa;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }
    
    public Integer getIdEndereco() {
        return idEndereco;
    }
    
    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }
    
    public Integer getIdPessoa() {
        return idPessoa;
    }
    
    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    public TipoEndereco getTipo() {
        return tipo;
    }
    
    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
    }
    
    public String getLogradouro() {
        return logradouro;
    }
    
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    
    public Integer getNumero() {
        return numero;
    }
    
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    public String getComplemento() {
        return complemento;
    }
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public String getCep() {
        return cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getPais() {
        return pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    @Override
    public String toString() {
        return "Endereco{" +
                "idEndereco=" + idEndereco +
                ", idPessoa=" + idPessoa +
                ", tipo=" + tipo +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
