//80/100


//https://www.mathblog.dk/tools/infix-postfix-converter/

//there is something missing(probably implementation of some functions (or something?!). You should use: https://en.wikipedia.org/wiki/Shunting-yard_algorithm#The_algorithm_in_detail
//Since the link from the task sheet didn't open at work, i found another one: https://brilliant.org/wiki/shunting-yard-algorithm/ and used that one instead.
//There must be something missing there. When you revise, use the one from Wikipedia to find the mistake.



package Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _15_InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> operatorStack = new ArrayDeque<>(100);
        ArrayDeque<String> outputQueue = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {

            String currentToken = input[i];

            if (consistsOfDigitsOrLetters(currentToken)) {

                outputQueue.add(currentToken);

            } else if (currentToken.equals("+") || currentToken.equals("-") ||
                    currentToken.equals("*") || currentToken.equals("/")) {

                while (operatorPeekHasHigherPriorityThanCurrentToken(currentToken, operatorStack)) {

                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {///////////
                        outputQueue.add(operatorStack.pop());
                    }

                    if (!operatorStack.isEmpty() && operatorStack.peek().equals("(")){//////////// dobaveno
                        operatorStack.pop();
                    }
                }

                operatorStack.push(currentToken);
            } else if (currentToken.equals("(")) {

                operatorStack.push(currentToken);
            } else if (currentToken.equals(")")) {

                while (!operatorStack.isEmpty()
                        && !operatorStack.peek().equals("(")) {
                    outputQueue.add(operatorStack.pop());
                }

                if (!operatorStack.isEmpty() && operatorStack.peek().equals("(")) {
                    operatorStack.pop();
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.add(operatorStack.pop());
        }

        while (!outputQueue.isEmpty()) {
            System.out.print(outputQueue.poll() + " ");
        }
        System.out.printf("");
    }




    static boolean consistsOfDigitsOrLetters(String string) {

        boolean isAllDigits = true;
        for (int i = 0; i < string.length(); i++) {

            if (!Character.isDigit(string.charAt(i)) && !Character.isLetter(string.charAt(i))) {
                isAllDigits = false;
                break;
            }
        }

        return isAllDigits;
    }

    static boolean operatorPeekHasHigherPriorityThanCurrentToken(String currentToken, ArrayDeque<String> operatorStack) {

        if (operatorStack.isEmpty() || currentToken.equals("*") || currentToken.equals("/") || operatorStack.peek().equals("(") ) {
            return false;
        }

        return true;
    }
}
