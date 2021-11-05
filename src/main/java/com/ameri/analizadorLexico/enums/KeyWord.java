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
        if(ESCRIBIR.getValue().equalsIgnoreCase(value)){
            return ESCRIBIR;
        } else if(ENTONCES.getValue().equalsIgnoreCase(value)){
            return ENTONCES;
        } else if(SI.getValue().equalsIgnoreCase(value)){
            return SI;
        } else if(FALSO.getValue().equalsIgnoreCase(value)){

            return FALSO;
        } else if(FIN.getValue().equalsIgnoreCase(value)){

            return FIN;
        } else if(VERDADERO.getValue().equalsIgnoreCase(value)){

            return VERDADERO;
        } else if(REPETIR.getValue().equalsIgnoreCase(value)){

            return REPETIR;
        } else if(INICIAR.getValue().equalsIgnoreCase(value)){

            return INICIAR;
        }

        return null;
    }
}
