package InputOutputFilesDirectories.Exercises;

import java.io.*;

public class _04_CountCharacterTypes {
    public static void main(String[] args) {

        String inputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Lab-Resources\\exerc4input.txt";
        String outputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Lab-Resources\\exerc4output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             PrintWriter pw = new PrintWriter(new FileWriter(outputPath))) {

            int vowelsCount = 0;
            int consonantsCount = 0;
            int punctuationCount = 0;

            char[] line = br.readLine().toCharArray();

            String vowels = "aeiou";
            String punctMarks = "?!,.";

            while (line != null) {
                for (char c : line) {

                    if (vowels.contains(c + "")) {
                        vowelsCount++;
                    } else if (punctMarks.contains(c + "")) {
                        punctuationCount++;
                    }
                     else if (c != ' ') {
                        consonantsCount++;
                    }
                }
                String lineStr = br.readLine();
                if (lineStr != null) {
                    line = lineStr.toCharArray();
                }
                else {
                    break;
                }
            }
            pw.println("Vowels: " + vowelsCount);
            pw.println("Consonants: " + consonantsCount);
            pw.println("Punctuation: " + punctuationCount);

        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
