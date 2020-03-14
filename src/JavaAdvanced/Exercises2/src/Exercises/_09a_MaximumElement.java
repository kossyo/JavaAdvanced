package Exercises;


import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _09a_MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commandsCount = Integer.parseInt(br.readLine());
        Deque<Integer> someNumbers = new ArrayDeque<>();
        Deque<Integer> maxNumbers = new ArrayDeque<>();
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < commandsCount; i++) {
            String[] commands = br.readLine().split(" ");

            String command = commands[0];
            switch (command){
                case "1":

                    int number = Integer.parseInt(commands[1]);

                    if (number >= maxValue){//
                        maxValue = number;
                        maxNumbers.push(maxValue);
                    }
                    someNumbers.push(number);
                    break;
///
                case "2":
                    int deletedItem = someNumbers.pop();
                    if (deletedItem == maxValue){
                        maxNumbers.pop();
                        if (!maxNumbers.isEmpty()) {
                            maxValue = maxNumbers.peek();
                        }
                        else {
                            maxValue = Integer.MIN_VALUE;
                        }
                    }
                    break;

                case "3":
                    System.out.println(maxNumbers.peek());
                    break;
            }
        }
    }
}
