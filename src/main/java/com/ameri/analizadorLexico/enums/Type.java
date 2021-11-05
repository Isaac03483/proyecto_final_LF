package com.ameri.analizadorLexico.enums;


public enum Type {
    
    IDENTIFICADOR("identificador"),
    ENTERO("entero"),
    OPERADOR("operador"),
    AGRUPACION("agrupacion"),
    LITERAL("literal"),
    COMENTARIO("comentario"),
    COMILLA("comilla"),
    COMILLA_SIMPLE("comilla simple"),
    DIAGONAL("diagonal"),
    IGUAL("igual"),
    MENOS("Menos"),
    GUION_BAJO("Guión bajo"),
    MAYOR_MENOR("mayor/menor"),
    PALABRAS_RESERVADAS("palabras reservadas"),
    OTRO("otro");

    private String type;

    /**
     * constructor
     * @param type
     */
    private Type(String type){
        this.type = type;
    }

    /**
     * retorna el tipo de cada enum
     * @return
     */
    public String getType(){return this.type;}
}
