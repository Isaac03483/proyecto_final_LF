package com.ameri.backend;


public class Character{
    
    private static final char[] groupingSigns = {')', '('};
    private static final char[] operationSigns = {'+', '*'};
    private static final char diagonal = '/';
    private static final char less = '-';
    private static final char underScore = '_';
    private static final char[] alphabetLowerCase = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's','t', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] alphabetCapitalLetter = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] digit = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final char[] punctuationMarks = {',', ';', ':'};
    private static final char[] greaterLess = {'<', '>'};
    private static final char comillaSimple = '\'';
    private static final char comilla = '"';
    private static final char equals = '=';

    /**
     * static method that compare two chars. return true if they're equals
     * @param character
     * @return
     */
    public static boolean isOperationSign(char character){

        for(int i = 0; i < operationSigns.length; i++){
            if(operationSigns[i] == character){
                return true;
            }
        }
        return false;
    }

    /**
     * static method, return true if two chars are equals
     * @param character
     * @return
     */
    public static boolean isPunctuationMark(char character){
        for(int i = 0; i < punctuationMarks.length; i++){
            if(punctuationMarks[i] == character){
                return true;
            }
        }
        return false;
    }

    /**
     * static method, return true if two chars are equals
     * @param character
     * @return
     */
    public static boolean isGroupingSign(char character){
        for(int i = 0; i < groupingSigns.length; i++){
            if(groupingSigns[i] == character){
                return true;
            }
        }
        return false;
    }


    /**
     * static method, compare if parameter is a space, return true if it is.
     * @param character
     * @return
     */
    public static boolean isSpaceChar(char character){

        return character == ' ';
    }


    /**
     * static method, compare two chars, return true if they both are alphabet
     * @param character
     * @return
     */
    public static boolean isAlphabetic(char character){

        for(int i = 0; i < alphabetCapitalLetter.length; i++){
            if(character == alphabetCapitalLetter[i] || character == alphabetLowerCase[i]){
                return true;
            }
        }

        return false;
    }

    /**
     * static method, return true if they both are digits
     * @param character
     * @return
     */
    public static boolean isDigit(char character){

        for(int i = 0; i < digit.length; i++){
            if(character == digit[i]){
                return true;
            }
        }
        return false;
    }

    public static boolean isMayus(char character){

        for(int i = 0; i < alphabetCapitalLetter.length; i++){
            if(character == alphabetCapitalLetter[i]){
                return true;
            }
        }

        return false;
    }

    public static boolean isEndLine(char character){
        return character == '\n';
    }

    public static boolean isLess(char character){
        return character == less;
    }

    public static boolean isDiagonal(char character){
        return character == diagonal;
    }

    public static boolean isUnderScore(char character){
        return character == underScore;
    }

    public static boolean isComillaSimple(char character){
        return character == comillaSimple;
    }

    public static boolean isComilla(char character){
        return character == comilla;
    }

    public static boolean isEquals(char character){
        return character == equals;
    }

    public static boolean isGreaterOrLess(char character){
        for(char value: greaterLess){
            if(character == value){
                return true;
            }
        }
        return false;
    }
}
