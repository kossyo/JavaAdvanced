package ExamPreparation._27aug2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _01_Agency {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> stackList = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        Deque<String> idStack = new ArrayDeque<>();
        Deque<String> agentsQueue = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));
        fillStack(stackList, idStack);

        String line;
        while (!"stop".equals((line = reader.readLine()))) {

            String[] tokens = line.split("-");
            String action = tokens[0];
            String parameters = "";

            if (tokens.length > 1) {
                 parameters = tokens[1];
            }

            switch (action) {
                case "add":

                    String[] parametersTokens = parameters.split("\\s+");
                    String idOrAgent = parametersTokens[0];
                    String idOrAgentParameter = parametersTokens[1];

                    switch (idOrAgent) {
                        case "ID":

                            idStack.push(idOrAgentParameter);
                            break;
                        case "agent":

                            agentsQueue.add(idOrAgentParameter);
                            break;
                    }
                    break;
                case "remove":

                    parametersTokens = parameters.split("\\s+");
                    idOrAgent = parametersTokens[0];
                    //idOrAgentParameter = parametersTokens[1];

                    switch (idOrAgent) {
                        case "ID":

                            if (!idStack.isEmpty()) {
                                System.out.printf("%s has been removed.%n", idStack.peek());
                                idStack.pop();
                            }
                            break;
                        case "agent":

                            if (!agentsQueue.isEmpty()) {
                                System.out.printf("%s has left the queue.%n", agentsQueue.peekLast());
                                agentsQueue.pollLast();
                                break;
                            }
                    }

                    break;
                case "sort":

                    if (!idStack.isEmpty()) {
                        idStack = idStack.stream()
                                .sorted(Comparator.reverseOrder())
                                .collect(Collectors.toCollection(ArrayDeque::new));
                    }
                    break;
            }
        }

        printOutput(idStack,agentsQueue);

       // System.out.println();
    }

    private static void printOutput(Deque<String> idStack, Deque<String> agentsQueue) {

        while (!idStack.isEmpty() && !agentsQueue.isEmpty()){

            System.out.printf("%s takes ID number: %s%n", agentsQueue.poll(), idStack.pop());
        }

        if (agentsQueue.isEmpty() && !idStack.isEmpty()){

            System.out.println("No more agents left.");

            while (!idStack.isEmpty()){

                System.out.printf("ID number: %s%n", idStack.pop());
            }
        }

        else if (idStack.isEmpty() && !agentsQueue.isEmpty()){

            while (!agentsQueue.isEmpty()) {
                System.out.printf("%s does not have an ID.%n", agentsQueue.poll());
            }
        }
    }


    private static void fillStack(List<String> stackList, Deque<String> idStack) {

        for (String s : stackList) {
            idStack.push(s);
        }
    }
}
