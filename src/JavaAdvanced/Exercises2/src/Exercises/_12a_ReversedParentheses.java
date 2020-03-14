package Exercises;

import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
public class _12a_ReversedParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] inputBrackets = scanner.nextLine().toCharArray();
        Deque <Character> openBraces = new ArrayDeque<>();
        boolean isBalanced = true;

        if (inputBrackets.length % 2 != 0){

            System.out.println("NO");
            return;
        }
        for(Character inputBracket : inputBrackets){

            if (inputBracket == '(' || inputBracket == '[' || inputBracket == '{' ){
                openBraces.push(inputBracket);
            }

            else{
                char currentOpeningBraceImTryingToMatch = openBraces.peek();

                if(inputBracket == ')' ){

                    inputBracket = '(';
                }
                else if(inputBracket == ']' ){

                    inputBracket = '[';
                }
                else if(inputBracket == '}' ){

                    inputBracket = '{';
                }

                if(inputBracket != currentOpeningBraceImTryingToMatch){
                    isBalanced = false;
                    break;

                }
                else{
                    openBraces.poll();
                }

            }

        }
        if(isBalanced)
            System.out.println("YES");
        else
            System.out.println("NO");



    }
}
