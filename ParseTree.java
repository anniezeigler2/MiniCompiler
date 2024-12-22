/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proglangcompiler;
import java.util.Stack;
import java.util.EmptyStackException;
/**
 *
 * @author annie
 */
public class ParseTree {
    
    private boolean isOperator(Token curr){
        if(curr.tokNum > 2 && curr.tokNum < 7)
            return true;
        return false;
    }
    
    public Token buildTree(Token [] arr){
        Stack <Token> stack = new Stack();
        Token root = arr[0];
        try{
            for (int i = arr.length - 1; i >= 0; i-- ){
                Token t = arr[i];

                if (isOperator(t)){
                    t.left = stack.pop();
                    t.right = stack.pop();
                    stack.push(t);
                } else {
                    stack.push(t);
                }    
            }

            root = stack.peek();
            stack.pop();
            
            if (!stack.isEmpty()){
                System.out.println("Parse Error: \nIncorrect number of tokens");
                System.exit(0);   
            }
        } catch (EmptyStackException e){
            System.out.println("Parse Error: \nIncorrect number of tokens");
            System.exit(0);
        }
        return root;
    }
}
