package com.chatkafka.enums;

import java.util.Arrays;

public enum Enviar {
    
    GERAL("chat-geral"),
    BRUNO("chat-bruno"),
    CASTRO("chat-castro"),
    CESAR("chat-cesar"),
    DAYVIDSON("chat-dayvidson"),
    GABRIEL("chat-gabriel"),
    JEAN("chat-jean"),
    MACHADO("chat-machado"),
    PAULO("chat-paulo"),
    CLEBER("chat-cleber"),
    CLEBSON("chat-clebson"),
    RAFAEL("chat-rafael"),
    RODRIGO("chat-rodrigo"),
    WILLIAN("chat-willian");
    
    private String chat;
    
    Enviar(String chat){
        this.chat = chat;
    }
    
    public String getChat(){return chat;}
    
    public static Enviar ofTipo(String chat){
        return Arrays.stream(Enviar.values())
                .filter(tp -> tp.getChat().equals(chat))
                .findFirst()
                .get();
    }
}
