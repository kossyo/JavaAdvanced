package Lab2._2018;

import java.util.*;

public class _06_DecimalToBinaryConverter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Long input = Long.parseLong(scanner.nextLine());
        ArrayDeque<Long> stack = new ArrayDeque<>();

        if (input == 0 ){
            System.out.println(0);
            return;
        }
        while (input>0) {

            stack.push(input % 2);
            input /= 2;
        }

        while (stack.size() > 0) {
            System.out.print(stack.pop());
        }

    }
}
