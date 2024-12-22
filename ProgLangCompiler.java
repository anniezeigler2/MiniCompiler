/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proglangcompiler;
import java.util.Scanner;

/**
 *
 * @author annie
 */
public class ProgLangCompiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Prefix format = + A B");
        System.out.println("Input in prefix format: ");
        String input = scan.nextLine();
        
        compile(input);
    }
    
    //Begins compiler function calling lexical analyzer
    //through code generator
    public static void compile(String in){
        lexAnalyzer(in);
    }
    
    //Breaks code into keywords, operators, and numbers
    public static void lexAnalyzer(String in){
        int count = 0;
        for(int i = 0; i < in.length(); i++){
            if (in.charAt(i) != ' ')
                count++;
        }
        
        Token[] lexOut = new Token[count];
        
        int curr = 0;
        int arrCount = 0;
        while(curr < in.length()){
            if(in.charAt(curr) != ' '){
                Token now = new Token(in.charAt(curr));
                lexOut[arrCount] = now;
                arrCount++;
            }
            curr++;
        }
        parser(lexOut);
    }
    
    //Converts tokens into a structure (syntax tree)
    public static void parser(Token[] tokArr){
        ParseTree tree = new ParseTree();
        Token root = tree.buildTree(tokArr);
        
        codeGen(root);
    }
   
    
    //Transforms parse structure into java code
    public static void codeGen(Token in){
        inOrder(in); 
        System.out.println("");
    }
        //Turns Binary Tree to String
        public static void inOrder(Token tok) {
            if (tok != null) {
                inOrder(tok.left);
                System.out.print(tok.data + " ");
                inOrder(tok.right);
            }
        }
  }


