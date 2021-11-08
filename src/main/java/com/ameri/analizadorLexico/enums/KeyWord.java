package com.ameri.analizadorLexico.enums;

public enum KeyWord {

    ESCRIBIR("ESCRIBIR"),
    FIN("FIN"),
    REPETIR("REPETIR"),
    INICIAR("INICIAR"),
    SI("SI"),
    VERDADERO("VERDADERO"),
    FALSO("FALSO"),
    ENTONCES("ENTONCES");

    private String value;

    KeyWord(String value) {
        this.value = value;
    }

    public String getValue() {return value;}

    public static KeyWord value(String value){
        if(ESCRIBIR.getValue().equals(value)){
            return ESCRIBIR;
        } else if(ENTONCES.getValue().equals(value)){
            return ENTONCES;
        } else if(SI.getValue().equals(value)){
            return SI;
        } else if(FALSO.getValue().equals(value)){

            return FALSO;
        } else if(FIN.getValue().equals(value)){

            return FIN;
        } else if(VERDADERO.getValue().equals(value)){

            return VERDADERO;
        } else if(REPETIR.getValue().equals(value)){

            return REPETIR;
        } else if(INICIAR.getValue().equals(value)){

            return INICIAR;
        }

        return null;
    }
}
