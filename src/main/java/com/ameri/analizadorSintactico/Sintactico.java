package com.ameri.analizadorSintactico;

import com.ameri.analizadorLexico.enums.KeyWord;
import com.ameri.analizadorLexico.enums.Type;
import com.ameri.analizadorLexico.token.Token;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Sintactico {

    private final List<Token> tokenList;
    private Token tokenEvaluando;
    private int colStatus;
    private int rowStatus;
    private final int[][] matriz = new int[16][17];
    private final String[][] values = new String[33][];
    private final String endStack = "$";
    private final String epsilon = "ε";
    private Stack<String> pila = new Stack<>();
    private final String[] noTerminal = new String[16];

    {
        for(int i = 0; i < matriz.length; i++){
            Arrays.fill(matriz[i], -1);
        }

        matriz[0][0] = 0;
        matriz[0][1] = 7;
        matriz[0][2] = 11;
        matriz[0][4] = 15;
        matriz[1][0] = 1;
        matriz[1][1] = 8;
        matriz[1][2] = 12;
        matriz[1][4] = 16;
        matriz[1][16] = -2;
        matriz[2][0] = 2;
        matriz[2][1] = 9;
        matriz[2][2] = 13;
        matriz[2][4] = 17;
        matriz[3][0] = 3;
        matriz[4][1] = 10;
        matriz[5][2] = 14;
        matriz[6][4] = 18;
        matriz[7][0] = 4;
        matriz[7][9] = -2;
        matriz[8][0] = 5;
        matriz[8][9] = -2;
        matriz[9][0] = 6;
        matriz[10][4] = 19;
        matriz[10][5] = 23;
        matriz[10][10] = 30;
        matriz[11][4] = 20;
        matriz[11][5] = 24;
        matriz[12][7] = 28;
        matriz[12][8] = 29;
        matriz[12][9] = -2;
        matriz[12][11] = -2;
        matriz[13][4] = 21;
        matriz[13][5] = 25;
        matriz[13][6] = 27;
        matriz[14][4] = 22;
        matriz[14][5] = 26;
        matriz[15][12] = 31;
        matriz[15][13] = 32;

        //transition values declaration

        values[0] = new String[]{"I", "FIN","G'"};
        values[1] =new String[]{"I", "FIN","G'"};
        values[2] = new String[]{"E"};
        values[3] = new String[]{"ESCRIBIR","V"};
        values[4] = new String[]{"E'", "F"};
        values[5] = new String[]{"E'"};
        values[6] = new String[]{"ESCRIBIR","V","FIN"};
        values[7] = new String[]{"I", "FIN","G'"};
        values[8] = new String[]{"I", "FIN","G'"};
        values[9] = new String[]{"R"};
        values[10] = new String[]{"REPETIR","N","INICIAR","F"};
        values[11] = new String[]{"I", "FIN","G'"};
        values[12] = new String[]{"I", "FIN","G'"};
        values[13] = new String[]{"C"};
        values[14] = new String[]{"SI","B","ENTONCES","H"};
        values[15] = new String[]{"I", "FIN","G'"};
        values[16] = new String[]{"I", "FIN","G'"};
        values[17] = new String[]{"A"};
        values[18] = new String[]{"IDENTIFICADOR","=","X"};
        values[19] = new String[]{"Y"};
        values[20] = new String[]{"N","O"};
        values[21] = new String[]{"N"};
        values[22] = new String[]{"IDENTIFICADOR"};
        values[23] = new String[]{"Y"};
        values[24] = new String[]{"N","O"};
        values[25] = new String[]{"N"};
        values[26] = new String[]{"NUMERO"};
        values[27] = new String[]{"LITERAL"};
        values[28] = new String[]{"+","X"};
        values[29] = new String[]{"*","X"};
        values[30] = new String[]{"(","Y",")","O"};
        values[31] = new String[]{"VERDADERO"};
        values[32] = new String[]{"FALSO"};

        noTerminal[0] = "G";
        noTerminal[1] = "G'";
        noTerminal[2] = "I";
        noTerminal[3] = "E";
        noTerminal[4] = "R";
        noTerminal[5] = "C";
        noTerminal[6] = "A";
        noTerminal[7] = "F";
        noTerminal[8] = "H";
        noTerminal[9] = "E'";
        noTerminal[10] = "X";
        noTerminal[11] = "Y";
        noTerminal[12] = "O";
        noTerminal[13] = "V";
        noTerminal[14] = "N";
        noTerminal[15] = "B";


        pila.push(endStack);
        pila.push(noTerminal[0]);
        tokenEvaluando = null;
        colStatus = 0;
        rowStatus = 0;

    }


    public Sintactico(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public void evaluar(){

        while(!pila.empty()){
            if(tokenEvaluando == null){
                this.getToken();
                this.getStatus();
            }
            System.out.println("ESTE ES EL ULTIMO VALOR DE LA PILA "+pila.peek());
            if(isNoTerminal(pila.peek())){
                setLastValue();
            }else{
                getPilaValue();
            }
        }
    }

    private void setLastValue() {
        int result = matriz[rowStatus][colStatus];
        System.out.println(rowStatus+" "+colStatus+"="+result);
        pila.pop();
        if(result != -2){
            if(result == -1){
                System.out.println("ERROR AL ANALIZAR: "+tokenEvaluando);
                pila.pop();
                tokenEvaluando = null;
                //pila.removeAllElements();
            } else{
                for(int i = values[result].length-1; i >= 0; i--){
                    pila.push(values[result][i]);
                }
            }
        } else {
            pila.push(epsilon);
        }
    }

    private void getPilaValue(){
        if(pila.peek().equals(endStack) || pila.peek().equals(epsilon)){
            System.out.println("SACANDO DE LA PILA: "+pila.peek());
            pila.pop();
        } else {
            switch (colStatus){
                case 0: if(pila.peek().equals(KeyWord.ESCRIBIR.getValue())){
                    System.out.println("SACANDO DE LA PILA "+pila.peek());
                    pila.pop();
                }
                    break;
                case 1: if(pila.peek().equals(KeyWord.REPETIR.getValue())){
                    System.out.println("SACANDO DE LA PILA "+pila.peek());
                    pila.pop();
                }
                    break;
                case 2: if(pila.peek().equals(KeyWord.SI.getValue())){
                    System.out.println("SACANDO DE LA PILA "+pila.peek());
                    pila.pop();
                }
                    break;
                case 3: if(pila.peek().equals(KeyWord.ENTONCES.getValue())){
                    System.out.println("SACANDO DE LA PILA "+pila.peek());
                    pila.pop();
                }
                    break;
                case 4:
                case 5:
                case 6: if(pila.peek().equals(tokenEvaluando.getType().getType())){
                    System.out.println("SACANDO DE LA PILA "+tokenEvaluando.getString());
                    pila.pop();
                }
                    break;
                case 7: if(pila.peek().equals("+")){
                    System.out.println("SACANDO DE LA PILA "+pila.peek());
                    pila.pop();
                }
                    break;
                case 8: if(pila.peek().equals("*")){
                    System.out.println("SACANDO DE LA PILA "+pila.peek());
                    pila.pop();
                }
                    break;
                case 9: if(pila.peek().equals(KeyWord.FIN.getValue())){
                    System.out.println("SACANDO DE LA PILA "+pila.peek());
                    pila.pop();
                }
                break;
                case 10: if(pila.peek().equals("(")){
                    System.out.println("SACANDO DE LA PILA "+pila.peek());
                    pila.pop();
                }
                    break;
                case 11: if(pila.peek().equals(")")){
                    System.out.println("SACANDO DE LA PILA "+pila.peek());
                    pila.pop();
                }
                    break;
                case 12: if(pila.peek().equals(KeyWord.VERDADERO.getValue())){
                    System.out.println("SACANDO DE LA PILA "+pila.peek());
                    pila.pop();
                }
                    break;
                case 13: if(pila.peek().equals(KeyWord.FALSO.getValue())){
                    System.out.println("SACANDO DE LA PILA "+pila.peek());
                    pila.pop();
                }
                    break;
                case 14: if(pila.peek().equals(KeyWord.INICIAR.getValue())){
                    System.out.println("SACANDO DE LA PILA "+pila.peek());
                    pila.pop();
                }
                    break;
                case 15: if(pila.peek().equals("=")){
                    System.out.println("SACANDO DE LA PILA "+pila.peek());
                    pila.pop();
                }
                    break;
            }
            tokenEvaluando = null;
        }
    }

    private boolean isNoTerminal(String peek) {

        for(int i = 0; i < noTerminal.length; i++){
            if(peek.equals(noTerminal[i])){
                rowStatus = i;
                return true;
            }
        }
        return false;
    }

    private void getStatus() {
        if(tokenEvaluando != null){
            if(tokenEvaluando.getType() == Type.PALABRAS_RESERVADAS){
                KeyWord keyWord = KeyWord.value(tokenEvaluando.getString());

                if (keyWord != null) {
                    switch (keyWord){
                        case ESCRIBIR: this.colStatus =0;
                            break;
                        case REPETIR: this.colStatus =1;
                            break;
                        case SI: this.colStatus = 2;
                            break;
                        case ENTONCES: this.colStatus = 3;
                            break;
                        case FIN: this.colStatus = 9;
                            break;
                        case VERDADERO: this.colStatus = 12;
                            break;
                        case FALSO: this.colStatus = 13;
                            break;
                        case INICIAR: this.colStatus = 14;
                            break;
                    }
                }
            } else{

                if(tokenEvaluando.getType() == Type.IDENTIFICADOR){
                    this.colStatus = 4;
                } else if(tokenEvaluando.getType() == Type.NUMERO){
                    this.colStatus = 5;
                } else if(tokenEvaluando.getType() == Type.LITERAL){
                    this.colStatus = 6;
                } else if(tokenEvaluando.getType() == Type.OPERADOR){
                    if(tokenEvaluando.getString().equals("+")){
                        this.colStatus = 7;
                    } else {
                        this.colStatus = 8;
                    }
                } else if(tokenEvaluando.getType() == Type.AGRUPACION){
                    if(tokenEvaluando.getString().equals("(")){
                        this.colStatus = 10;
                    } else {
                        this.colStatus = 11;
                    }
                } else if(tokenEvaluando.getType() == Type.IGUAL){
                    this.colStatus = 15;
                }
            }
        } else{
            this.colStatus = 16;
        }
    }

    private void getToken() {
        if(tokenList.size()> 0){
            tokenEvaluando = tokenList.get(0);
            tokenList.remove(0);
        }
    }


}
