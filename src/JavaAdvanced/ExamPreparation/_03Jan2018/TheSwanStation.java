package ExamPreparation._03Jan2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TheSwanStation {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Long> upperRow = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Long> lowerRow = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toCollection(ArrayDeque::new));

        List<Long> winners = new LinkedList<>();

        while (true) {
            if (lowerRow.peek() % upperRow.peek() == 0) {

                upperRow.poll();
                winners.add(lowerRow.poll());
            } else {
                lowerRow.add(lowerRow.poll() + 1);
            }
            if (winners.size() == 6){
                break;
            }
        }
        System.out.println(winners.toString().replaceAll("[\\[\\]]", ""));
    }
}
