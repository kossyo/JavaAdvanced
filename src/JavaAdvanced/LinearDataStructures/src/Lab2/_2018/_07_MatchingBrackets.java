package Lab2._2018;
import java.util.ArrayDeque;
import java.util.Scanner;

public class _07_MatchingBrackets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();


        for (int i = 0; i < input.length(); i++){

            if (input.charAt(i) == '('){

                stack.push(i);

            }

            else if(input.charAt(i) == ')'){
                System.out.println(input.substring(stack.pop(), i+1));
            }
        }
    }
}
