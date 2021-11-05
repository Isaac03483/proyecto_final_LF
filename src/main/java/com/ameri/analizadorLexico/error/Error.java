package com.ameri.analizadorLexico.error;

import com.ameri.analizadorLexico.enums.ErrorType;

public class Error {
    
    private int row;
    private int column;
    private ErrorType error;

    {
        error = null;
    }

    /**
     * constructor
     * @param row
     * @param column
     * @param error
     */
    public Error(int row, int column, ErrorType error){
        this.row = row;
        this.column = column;
        this.error = error;
    }

    /**
     * retorna el número de fila del error
     * @return
     */
    public int getRow(){return this.row;}

    /**
     * retorna la columna del error
     * @return
     */
    public int getColumn(){return this.column;}

    /**
     * retorna el tipo de error que es
     * @return
     */
    public ErrorType getErrorType(){return this.error;}
}
