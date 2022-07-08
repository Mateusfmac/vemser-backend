package br.com.vemser.pessoaapi.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Contato {
    private Integer idContato;
    private Integer idPessoa;
    @NotNull(message = "insira um tipo de contato valido")
    private String tipoContato;
    @NotNull
    @Size(max = 13, message = "insira um numero com ate 13 digitos")
    private String numero;
    @NotBlank
    @NotNull
    private String descricao;
    
    public Contato() {
    }
    
    public Contato(Integer idContato, Integer idPessoa, String tipoContato, String numero, String descricao) {
        this.idContato = idContato;
        this.idPessoa = idPessoa;
        this.tipoContato = tipoContato;
        this.numero = numero;
        this.descricao = descricao;
    }
    
    public Integer getIdContato() {
        return idContato;
    }
    
    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }
    
    public String getTipoContato() {
        return tipoContato;
    }
    
    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Integer getIdPessoa() {
        return idPessoa;
    }
    
    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", tipoContato='" + tipoContato + '\'' +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
