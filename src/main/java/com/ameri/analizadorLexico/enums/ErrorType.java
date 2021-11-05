package com.ameri.analizadorLexico.enums;

public enum ErrorType {
    //ID ERROR
    IDERROR("Error de identificador", "Se esperaba un valor alfabético o numérico."),
    //NUMBER ERROR
    NUMBERERROR("Error numérico","Se esperaba un número."),
    //OTHER
    OPERATIONERROR("Error de operación", "Se esperaba solamente el signo de operación."),
    LESSERROR("Error de signo menos", "Este signo solo puede ser utilizado para expresar numeros negativos o dentro de un identificador, obviando los comentarios y las literales."),
    GROUPINGERROR("Error de agrupación", "Se esperaba solamente el signo de agrupación."),
    LITERALERROR("Error de literal", "Se esperaba una comilla para finalizar la literal."),
    KEYWORDERROR("Error de palabra reservada", "La palabra ingresada no forma parte del lenguaje."),
    EQUALSERROR("Error del signo igual", "El signo tiene un error"),
    SPECIALERROR("Error especial", "El valor no forma parte del alfabeto."),
    ZEROERROR("Error de cero", "El cero no puede venir a compañado de más números.");
    //FIN ERROR
    private String type;
    private String message;

    /**
     * constructor
     * @param type
     * @param message
     */
    private ErrorType(String type, String message){
        this.type = type;
        this.message = message;
    }

    /**
     * retorna el tipo de cada enum
     * @return
     */
    public String getType(){return this.type;}

    /**
     * retorna el mensaje de cada enum
     * @return
     */
    public String getMessage(){return this.message;}
}
