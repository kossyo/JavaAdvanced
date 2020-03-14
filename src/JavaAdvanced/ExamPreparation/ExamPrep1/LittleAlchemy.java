package ExamPreparation.ExamPrep1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class LittleAlchemy {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Long> tableQueue = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Long::parseLong)
                .collect(Collectors.toCollection(ArrayDeque::new));

        long storage = 0;

        String line;
        while (!"Revision".equals((line = reader.readLine()))) {

            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            long parameter = Long.parseLong(tokens[2]);

            switch (command) {
                case "Apply":

                    for (int i = 0; i < parameter; i++) {

                        if (tableQueue.isEmpty()) {
                            break;
                        }

                        long pocket = tableQueue.poll();
                        pocket--;
                        if (pocket != 0) {
                            tableQueue.offer(pocket);
                        } else
                            storage++;
                    }
                    break;

                case "Air":

                    if (storage != 0) {
                        storage--;
                        tableQueue.offer(parameter);
                    }
                    break;
            }
        }
        System.out.println(tableQueue.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(storage);
    }
}
