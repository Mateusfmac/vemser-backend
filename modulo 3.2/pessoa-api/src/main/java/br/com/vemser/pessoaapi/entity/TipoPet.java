package br.com.vemser.pessoaapi.entity;

import java.util.Arrays;

public enum TipoPet {
    GUAXINIM(0),
    CACHORRO(1),
    GATO(2);
    
    private Integer tipo;
    
    TipoPet(Integer tipo) {
        this.tipo = tipo;
    }
    
    public Integer getTipo() {
        return tipo;
    }
    
    public static TipoPet ofTipo(Integer tipo) {
        return Arrays.stream(TipoPet.values())
                .filter(tipoPet -> tipoPet.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}
