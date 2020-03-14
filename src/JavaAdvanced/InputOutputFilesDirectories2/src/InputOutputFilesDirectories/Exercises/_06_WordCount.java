package InputOutputFilesDirectories.Exercises;

import java.io.*;
import java.util.*;

public class _06_WordCount {
    public static void main(String[] args) {

        String wordsFile = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Exercises-Resources\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Exercises-Resources\\StringProcessing.FunctionalProgramming.Exercises Resources\\words.txt";
        String inputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Exercises-Resources\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Exercises-Resources\\StringProcessing.FunctionalProgramming.Exercises Resources\\text.txt";
        String outputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Exercises-Resources\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Exercises-Resources\\StringProcessing.FunctionalProgramming.Exercises Resources\\results.txt";

        Map<String, Integer> wordsSearched = new HashMap<>();

        try (Scanner scanner = new Scanner(new FileReader(wordsFile));
             PrintWriter pw = new PrintWriter(new FileWriter(outputPath))
        ) {

            while (scanner.hasNext()) {

                String currentWord = "";
                currentWord = scanner.next();
                wordsSearched.put(currentWord, 0);
            }

            Scanner scanner2 = new Scanner(new FileReader(inputPath));

            while (scanner2.hasNext()) {

                String currentWord = scanner2.next();
                if (wordsSearched.containsKey(currentWord)){
                    wordsSearched.put(currentWord, wordsSearched.get(currentWord) + 1);
                }
            }

            wordsSearched.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(word -> pw.printf("%s - %d%n", word.getKey(), word.getValue()));


        } catch (IOException e) {

        }
    }
}
