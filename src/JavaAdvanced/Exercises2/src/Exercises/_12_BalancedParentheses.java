//check cases {}[] -> this should be balanced

package Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _12_BalancedParentheses {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char[] inputBrackets = scanner.nextLine().toCharArray();
        Deque<Character> openBraces = new ArrayDeque<>();
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

    static char[] reverseCharArray(char[] array) {

        String string = "";

        for (int i = 0; i < array.length; i++) {

            string += array[i];
        }
        char[] newArray = new char[string.length()];

        for (int i = 0; i < array.length; i++) {

            newArray[i] = string.charAt(array.length - 1 - i);
        }
        newArray[array.length - 1] = array[0];

        return newArray;
    }

    static String charArrayToString(char[] charArray) {

        String string = "";

        for (int i = 0; i < charArray.length; i++) {
            string += charArray[i];
        }

        return string;
    }

}
