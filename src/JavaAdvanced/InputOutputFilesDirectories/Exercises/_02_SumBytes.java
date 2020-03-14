package InputOutputFilesDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class _02_SumBytes {
    public static void main(String[] args) {

        String inputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Lab-Resources\\exerc1.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            // OR: BufferedReader br = Files.newBufferedReader(Paths.get(inputPath))

            String line = br.readLine();
            long sum = 0;
            while (line != null) {

                for (char c : line.toCharArray()) {
                    sum += c;
                }
                line = br.readLine();
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
