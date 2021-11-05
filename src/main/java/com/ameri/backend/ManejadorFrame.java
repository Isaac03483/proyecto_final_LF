package com.ameri.backend;

import com.ameri.analizadorLexico.Automata;
import com.ameri.analizadorLexico.token.Token;
import com.ameri.swing.FramePrincipal;

import java.util.ArrayList;
import java.util.List;

public class ManejadorFrame {

    private final FramePrincipal principal;
    private int row;
    private int column;
    private List<Token> tokenList = new ArrayList<>();
    private boolean error;

    {
        this.row = 1;
        this.column=0;
    }

    public ManejadorFrame(FramePrincipal principal) {
        this.principal = principal;
    }


    public void getTotalRowsColumns(){
        int caretPosition = this.principal.getjTextAreaUno().getCaretPosition();
        this.column = caretPosition;
        this.row = 1;
        int provisional = 0;
        char[] chars = this.principal.getjTextAreaUno().getText().toCharArray();
        for(int i = 0; i < chars.length +1; i++){
            if(i < chars.length && i < caretPosition){
                if(Character.isEndLine(chars[i])){
                    this.row++;
                    this.column-=provisional;
                    this.column--;
                    provisional= 0;
                } else {
                    provisional++;
                }
            } else{
                break;
            }
        }

        this.principal.getEtiquetaDetalle().setText("Fil: "+this.row+". Col: "+this.column+".");
    }

    public void analizadorInit(){

        char[] chars = this.principal.getjTextAreaUno().getText().toCharArray();
        Automata automata = new Automata(chars);
        automata.evaluar();
        this.error = automata.getError();

        if(!this.error){
            tokenList = automata.getTokenList();

            tokenList.forEach(t -> System.out.println(t.getString()+" "+t.getType().getType()));
        } else {
            tokenList = automata.getErrorList();
            this.principal.getjTextAreaDos().setText("");
            System.out.println(tokenList.size());
            tokenList.forEach(t -> this.principal.getjTextAreaDos().append(t.getString()+" "+t.getError().getErrorType().getMessage()+"\n"));
        }
    }

}
