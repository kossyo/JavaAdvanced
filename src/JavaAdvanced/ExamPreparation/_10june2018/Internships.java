package ExamPreparation._10june2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Internships {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<String> problemsStack = new ArrayDeque<>();
        Deque<String> candidatesQueue = new ArrayDeque<>();

        int problemsCount = Integer.parseInt(reader.readLine());
        int candidatesCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < problemsCount; i++) {

            problemsStack.push(reader.readLine());
        }

        Pattern pattern = Pattern.compile("^\\s*[A-Z][a-z]+\\s+[A-Z][a-z]+\\s*$");   ///// * instead of +? remove \s. TAB?

        for (int i = 0; i < candidatesCount; i++) {

            String potentialName = reader.readLine();
            Matcher matcher = pattern.matcher(potentialName);

            if (matcher.find()) {

                candidatesQueue.add(potentialName);
            }
        }

        while (!candidatesQueue.isEmpty()) {
            if (problemsStack.isEmpty()) {
                System.out.println(candidatesQueue.toString().replaceAll("[\\[\\]]", ""));
                break;
            }


            String currentCandidate = candidatesQueue.poll();
            String currentProblem = problemsStack.poll();

            if (isProblemSolved(currentCandidate, currentProblem)){

                candidatesQueue.add(currentCandidate);
                System.out.printf("%s solved %s.%n", currentCandidate, currentProblem );

            }

            else {
                problemsStack.add(currentProblem);
                System.out.printf("%s failed %s.%n", currentCandidate, currentProblem);
            }
            if (candidatesQueue.size() == 1){
                System.out.printf("%s gets the job!", candidatesQueue.poll());
            }
        }
    }

    private static boolean isProblemSolved(String candidate, String problem) {

        long candidateSum = 0;
        long problemSum = 0;

        for (int i = 0; i < candidate.length(); i++) {

            candidateSum += candidate.charAt(i);
        }

        for (int i = 0; i < problem.length(); i++) {

            problemSum += problem.charAt(i);
        }

        return candidateSum > problemSum;
    }
}
