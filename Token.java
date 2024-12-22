/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proglangcompiler;

/**
 *
 * @author annie
 */
public class Token {
    public int tokNum;
    public char data;
    
    public Token left;
    public Token right;
    
    public char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 
                            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 
                            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public char[] integers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    
    public Token(char c){
        data = c;
        
        //Operators
        switch (c){
            case '+':
                tokNum = 3;
            case '-':
                tokNum = 4;
            case '*':
                tokNum = 5;
            case '/':
                tokNum = 6;
        }
        
        //Identifiers 
        for (int i = 0; i < alphabet.length; i++){
            if (c == alphabet[i])
                tokNum = 2;
        }
        
        //Integers
        for (int i = 0; i < integers.length; i++){
            if (c == integers[i])
                tokNum = 1;
        }
        
        if(tokNum == 0){
            System.out.println("Token Error: \nInvalid input symbol!");
            System.exit(0);
        }
    }
}
