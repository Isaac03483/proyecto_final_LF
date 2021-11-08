package com.ameri.analizadorLexico;



import com.ameri.analizadorLexico.enums.ErrorType;
import com.ameri.analizadorLexico.enums.KeyWord;
import com.ameri.analizadorLexico.enums.Type;
import com.ameri.analizadorLexico.error.Error;
import com.ameri.analizadorLexico.token.Token;
import com.ameri.backend.Character;
import java.util.ArrayList;
import java.util.List;

public class Automata{
    
    private int actualStatus = 0;
    private int oldStatus = 0;
    private char[] chars;
    private String tokenString="";
    private final List<Token> tokenList = new ArrayList<>();
    private final List<Token> errorList = new ArrayList<>();
    private boolean error;
    private final int[][] transition = new int[11][15];
    private ErrorType errorType;
    private Type type;


    {
        this.error = false;
        type = null;
        errorType = null;
        /**
         * Tabla de transición
         * Lado izquierdo de la matriz: Estado. Lado derecho de la matriz: acción
         * Estados: 0 -
         */
        transition[0][0] = 4;
        transition[0][1] = 4;
        transition[0][2] = 1;
        transition[0][3] = 10;
        transition[0][4] = 6;
        transition[0][5] = 4;
        transition[0][6] = 4;
        transition[0][7] = -1;
        transition[0][8] = 2;
        transition[0][9] = 8;
        transition[0][10] =10;
        transition[0][11] = 5;
        transition[0][12] = 4;
        transition[0][13] = 4;
        transition[0][14] = 4;
        //fin fila
        transition[1][0] = -1;
        transition[1][1] = -1;
        transition[1][2] = -1;
        transition[1][3] = -1;
        transition[1][4] = -1;
        transition[1][5] = -1;
        transition[1][6] = -1;
        transition[1][7] = -1;
        transition[1][8] = 2;
        transition[1][9] = -1;
        transition[1][10] = -1;
        transition[1][11] = -1;
        transition[1][12] = -1;
        transition[1][13] = -1;
        transition[1][14] = -1;
        //fin fila
        transition[2][0] = -1;
        transition[2][1] = -1;
        transition[2][2] = -1;
        transition[2][3] = -1;
        transition[2][4] = -1;
        transition[2][5] = -1;
        transition[2][6] = -1;
        transition[2][7] = 3;
        transition[2][8] = 2;
        transition[2][9] = -1;
        transition[2][10] = -1;
        transition[2][11] = -1;
        transition[2][12] = -1;
        transition[2][13] = -1;
        transition[2][14] = -1;
        //fin fila
        transition[3][0] = -1;
        transition[3][1] = -1;
        transition[3][2] = -1;
        transition[3][3] = -1;
        transition[3][4] = -1;
        transition[3][5] = -1;
        transition[3][6] = -1;
        transition[3][7] = 3;
        transition[3][8] = -1;
        transition[3][9] = -1;
        transition[3][10] = -1;
        transition[3][11] = -1;
        transition[3][12] = -1;
        transition[3][13] = -1;
        transition[3][14] = -1;
        //fin fila
        transition[4][0] = -1;
        transition[4][1] = -1;
        transition[4][2] = -1;
        transition[4][3] = -1;
        transition[4][4] = -1;
        transition[4][5] = -1;
        transition[4][6] = -1;
        transition[4][7] = -1;
        transition[4][8] = -1;
        transition[4][9] = -1;
        transition[4][10] = -1;
        transition[4][11] = -1;
        transition[4][12] = -1;
        transition[4][13] = -1;
        transition[4][14] = -1;
        //fin fila
        transition[5][0] = -1;
        transition[5][1] = -1;
        transition[5][2] = -1;
        transition[5][3] = -1;
        transition[5][4] = -1;
        transition[5][5] = -1;
        transition[5][6] = -1;
        transition[5][7] = -1;
        transition[5][8] = -1;
        transition[5][9] = -1;
        transition[5][10] = -1;
        transition[5][11] = 5;
        transition[5][12] = -1;
        transition[5][13] = -1;
        transition[5][14] = -1;
        //fin fila
        transition[6][0] = 6;
        transition[6][1] = 6;
        transition[6][2] = 6;
        transition[6][3] = 6;
        transition[6][4] = 7;
        transition[6][5] = 6;
        transition[6][6] = 6;
        transition[6][7] = 6;
        transition[6][8] = 6;
        transition[6][9] = 6;
        transition[6][10] =6;
        transition[6][11] = 6;
        transition[6][12] = 6;
        transition[6][13] = 6;
        transition[6][14] = 6;
        //fin fila
        transition[7][0] = -1;
        transition[7][1] = -1;
        transition[7][2] = -1;
        transition[7][3] = -1;
        transition[7][4] = -1;
        transition[7][5] = -1;
        transition[7][6] = -1;
        transition[7][7] = -1;
        transition[7][8] = -1;
        transition[7][9] = -1;
        transition[7][10] = -1;
        transition[7][11] = -1;
        transition[7][12] = -1;
        transition[7][13] = -1;
        transition[7][14] = -1;
        //fin fila
        transition[8][0] = -1;
        transition[8][1] = -1;
        transition[8][2] = -1;
        transition[8][3] = -1;
        transition[8][4] = -1;
        transition[8][5] = -1;
        transition[8][6] = -1;
        transition[8][7] = -1;
        transition[8][8] = -1;
        transition[8][9] = 9;
        transition[8][10] = -1;
        transition[8][11] = -1;
        transition[8][12] = -1;
        transition[8][13] = -1;
        transition[8][14] = -1;
        //fin fila
        transition[9][0] = 9;
        transition[9][1] = 9;
        transition[9][2] = 9;
        transition[9][3] = 9;
        transition[9][4] = 9;
        transition[9][5] = 9;
        transition[9][6] = 9;
        transition[9][7] = 9;
        transition[9][8] = 9;
        transition[9][9] = 9;
        transition[9][10] =9;
        transition[9][11] = 9;
        transition[9][12] = 9;
        transition[9][13] = 9;
        transition[9][14] = 9;
        //fin fila
        transition[10][0] = -1;
        transition[10][1] = -1;
        transition[10][2] = 10;
        transition[10][3] = 10;
        transition[10][4] = -1;
        transition[10][5] = -1;
        transition[10][6] = -1;
        transition[10][7] = 10;
        transition[10][8] = 10;
        transition[10][9] = -1;
        transition[10][10] = 10;
        transition[10][11] = -1;
        transition[10][12] = -1;
        transition[10][13] = -1;
        transition[10][14] = -1;
        //fin fila

    }

    public Automata(char[] chars) {
        this.chars = chars;
    }

    /**
     * método estático que devuelve el valor de cada carácter dependiendo
     * de qué caracter sea
     * @param character
     * @return
     */
    private int getCharacterInt(char character, int row, int column){

        int result;

        if(Character.isOperationSign(character)){
            if(this.actualStatus != 6 && this.actualStatus != 9){
                saveToken(row, column);
            }
            if(type != Type.LITERAL && type != Type.COMENTARIO){
                type = Type.OPERADOR;
                errorType = ErrorType.OPERATIONERROR;
            }
            result = 0;
        } else if(Character.isLess(character)){
            if(type != Type.LITERAL && type != Type.COMENTARIO){
                if(type != Type.IDENTIFICADOR){
                    type = Type.MENOS;
                    errorType= ErrorType.LESSERROR;
                }
            }
            result = 2;
        } else if(Character.isUnderScore(character)){
            if(type != Type.LITERAL && type != Type.COMENTARIO){
                type = Type.IDENTIFICADOR;
                errorType= ErrorType.IDERROR;
            }
            result = 3;
        } else if(Character.isComilla(character)){
            type = Type.LITERAL;
            errorType = ErrorType.LITERALERROR;
            result = 4;
        } else if(Character.isComillaSimple(character)){
            if(type != Type.LITERAL && type != Type.COMENTARIO){
                type = Type.COMILLA_SIMPLE;
                errorType= ErrorType.SPECIALERROR;
            }
            result = 5;
        } else if(Character.isDigit(character)){
            if(character == '0'){
                if(this.actualStatus == 0){
                    if(type != Type.LITERAL && type != Type.COMENTARIO && type != Type.IDENTIFICADOR){
                        type = Type.NUMERO;
                        errorType= ErrorType.ZEROERROR;
                    }
                    result = 6;
                } else{
                    if(type != Type.LITERAL && type != Type.COMENTARIO && type != Type.IDENTIFICADOR){
                        type = Type.NUMERO;
                        errorType= ErrorType.ZEROERROR;
                    }
                    result = 7;
                }
            } else {

                if(actualStatus == 4){
                    result = 6;
                } else {
                    if(type != Type.LITERAL && type != Type.COMENTARIO && type != Type.IDENTIFICADOR){
                        type = Type.NUMERO;
                        errorType= ErrorType.NUMBERERROR;
                    }
                    result = 8;
                }
            }
        } else if(Character.isDiagonal(character)){
            if(type != Type.LITERAL && type != Type.COMENTARIO){
                type = Type.DIAGONAL;
                errorType= ErrorType.SPECIALERROR;
            }
            if(actualStatus == 8){
                if(type != Type.LITERAL && type != Type.COMENTARIO){
                    type = Type.COMENTARIO;
                }
            }
            result = 9;
        } else if (Character.isAlphabetic(character)){
            if(Character.isMayus(character)){
                if(this.actualStatus == 0 || this.actualStatus == 5){
                    if(type != Type.LITERAL && type != Type.COMENTARIO  && type != Type.NUMERO){
                        type = Type.PALABRAS_RESERVADAS;
                        errorType= ErrorType.KEYWORDERROR;
                    }
                    result = 11;
                } else {
                    result = 10;
                }
            } else {
                if(type != Type.LITERAL && type != Type.COMENTARIO && type != Type.PALABRAS_RESERVADAS && type != Type.NUMERO){
                    type = Type.IDENTIFICADOR;
                    errorType= ErrorType.IDERROR;
                }
                result = 10;
            }
        } else if(Character.isEquals(character)){
            if(this.actualStatus != 6 && this.actualStatus != 9){
                saveToken(row, column);
            }
            if(type != Type.LITERAL && type != Type.COMENTARIO){
                type = Type.IGUAL;
                errorType= ErrorType.EQUALSERROR;
            }
            result = 12;
        } else if(Character.isGroupingSign(character)){
            if(this.actualStatus != 6 && this.actualStatus != 9){
                saveToken(row, column);
            }
            if(type != Type.LITERAL && type != Type.COMENTARIO){
                type = Type.AGRUPACION;
                errorType= ErrorType.GROUPINGERROR;
            }
            result = 13;
        } else {
            if(type != Type.LITERAL && type != Type.COMENTARIO){
                type = Type.OTRO;
                errorType= ErrorType.SPECIALERROR;
            }
            result = 14;
        }

        return result;
    }

    public void evaluar(){

        int row = 1;
        int column = 0;
        for(int i = 0; i < chars.length+1; i++){
            if(i < chars.length){
                column++;
                reader(chars[i], row, column);
                if(Character.isEndLine(chars[i])){
                    row++;
                    column = 0;
                }
            } else{
                if(actualStatus != -1 && actualStatus != 6){
                    saveToken(row, column);
                } else {
                    saveError(row, column);

                }
            }
        }
    }

    public void reader(char character, int row, int column){
        if(!Character.isSpecialCharacter(character)){
            if(!Character.isSpaceChar(character) && !Character.isEndLine(character)){
                oldStatus = actualStatus;
                int change = getCharacterInt(character, row, column);
                actualStatus = transition[actualStatus][change];
                tokenString+=character;
                if(actualStatus == -1){
                    saveError(row, column);
                } else {
                    if(Character.isEquals(character) || Character.isGroupingSign(character) || Character.isGreaterOrLess(character) || Character.isOperationSign(character)){
                        if(type != Type.LITERAL){
                            saveToken(row, column);
                        }
                    }
                }
            } else{
                switch (actualStatus){
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        saveToken(row, column);
                        break;
                    default:
                        if(Character.isSpaceChar(character)){
                            if(actualStatus != 6){
                                saveError(row, column);

                            } else{
                                tokenString+=character;
                            }
                        } else {
                            saveError(row, column);
                        }
                        break;
                }
            }
        }
    }

    private void saveError(int row, int column) {
        if(tokenString.length() > 0 && actualStatus != 0){
            errorList.add(new Token(tokenString.trim(), type,new Error(row, column, errorType)));
            tokenString="";
            type = null;
            errorType = null;
            actualStatus = 0;
            error = true;
        }

    }

    public void saveToken(int row, int column){

        if(tokenString.length() > 0 && actualStatus != 0){
            if(actualStatus == 5){
                if(KeyWord.value(tokenString.trim()) != null){
                    tokenList.add(new Token(tokenString.trim(), type,column,row));
                    tokenString="";
                    type = null;
                    errorType = null;
                    actualStatus = 0;
                } else {
                    saveError(row,column);
                }
            } else {
                tokenList.add(new Token(tokenString.trim(), type,column,row));
                tokenString="";
                type = null;
                errorType = null;
                actualStatus = 0;
            }
        }
    }

    public char[] getChars() {return chars;}

    public void setChars(char[] chars) {this.chars = chars;}

    public boolean getError(){return this.error;}

    public List<Token> getTokenList(){return this.tokenList;}

    public List<Token> getErrorList(){return this.errorList;}

}
