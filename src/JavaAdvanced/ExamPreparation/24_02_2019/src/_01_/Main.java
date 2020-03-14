package _01_;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine());

        Deque<String> input = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        Deque<String> hallsQueue = new ArrayDeque<>();
        Pair<String, List<Integer>> currentHall = new Pair<>("", new LinkedList<>());

        int overflow = 0;
        // ами ако дадат група, по-голяма от capacity?

        while (!input.isEmpty()) {

            String currentChunk = input.pollLast();
            if (Character.isLetter(Objects.requireNonNull(currentChunk).charAt(0))) {

                hallsQueue.add(String.valueOf(currentChunk.charAt(0)));
            } else {


                if (!hallsQueue.isEmpty()) {     //има отворена зала

//                    if (overflow != 0){
//
//
//                    }

                    int groupTryingToEnter = Integer.parseInt(input.pollLast());


                    if (currentHall.getValue().stream().mapToInt(Integer::byteValue).sum() + groupTryingToEnter <= capacity) {//     може да се събeрат

                        List<Integer> grownGroup = new LinkedList<>(currentHall.getValue());
                        grownGroup.add(groupTryingToEnter);

                        currentHall = new Pair<>(currentChunk, grownGroup);
                    } else {

                        System.out.println(currentHall.getKey() + " " + currentHall.getValue());

                        if (groupTryingToEnter <= capacity) {

                            overflow = groupTryingToEnter;
                        }
                        currentHall = new Pair<>("", new LinkedList<>());

                    }

                }
            }


        }


    }
}
