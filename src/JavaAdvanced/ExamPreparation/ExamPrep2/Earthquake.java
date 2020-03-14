package ExamPreparation.ExamPrep2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Earthquake {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Deque<Integer>> outerQueue = new ArrayDeque<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {

            Deque<Integer> innerQueue = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayDeque::new));
            outerQueue.add(innerQueue);
        }
        List<Integer> winners = new LinkedList<>();

            while (!outerQueue.isEmpty() ) {

                Deque<Integer> topQueue = outerQueue.poll();
                if (topQueue.size() == 1) {

                    winners.add(topQueue.poll());
                } else {//topQueue HAS a beater and a victim
                    Integer beater = topQueue.poll();
                    Integer victim = topQueue.poll();

                    if (beater >= victim) {
                        topQueue.push(beater);
                        outerQueue.push(topQueue);
                    } else {
                        winners.add(beater);
                        topQueue.push(victim);
                        outerQueue.add(topQueue);
                    }
                }
            }
            System.out.println(winners.size());
            winners.forEach(x -> System.out.print(x + " "));
    }
}
