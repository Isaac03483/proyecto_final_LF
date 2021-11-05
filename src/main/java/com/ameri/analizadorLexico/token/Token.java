package com.ameri.analizadorLexico.token;

import com.ameri.analizadorLexico.error.Error;
import com.ameri.analizadorLexico.enums.Type;

public class Token {
    
    private String string;
    private int column;
    private int row;
    private Type type;
    private Error error;

    {
        error = null;
        column = 0;
    }

    /**
     * constructor
     * @param string
     * @param type
     * @param column
     */
    public Token(String string, Type type, int column, int row){
        this.string = string;
        this.type = type;
        this.column = column;
        this.row = row;
    }

    /**
     * constructor
     * @param string
     * @param type
     * @param error
     */
    public Token(String string, Type type, Error error){
        this.string = string;
        this.type = type;
        this.error = error;
    }

    /**
     * setter
     * @param type
     */
    public void setType(Type type){this.type = type;}

    /**
     * getter
     * @return
     */
    public Error getError(){return this.error;}

    /**
     * getter
     * @return
     */
    public String getString(){return this.string;}

    /**
     * getter
     * @return
     */
    public Type getType(){return this.type;}

    /**
     * getter
     * @return
     */
    public int getColumn(){return this.column;}

    public int getRow(){return this.row;}

    @Override
    public String toString() {
        return this.string+" "+this.type.getType();
    }
}
