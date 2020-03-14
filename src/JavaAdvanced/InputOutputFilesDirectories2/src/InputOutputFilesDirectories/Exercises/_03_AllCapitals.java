//тук си блъсках главата един час, докато открия ,че трябва да са в try-catch-resources,което значи тия работи да са в () скоби на try,
// а не просто само методът да хвърля throws IOException.

package InputOutputFilesDirectories.Exercises;

import java.io.*;

public class _03_AllCapitals {
    public static void main(String[] args) throws IOException {

        String inputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Lab-Resources\\exerc1.txt";
        String outputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Lab-Resources\\exerc3output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             PrintWriter pw = new PrintWriter(new FileWriter(outputPath))) {
            String line = br.readLine();
            while (line != null) {

                String capitalized = line.toUpperCase();

                pw.println(capitalized);

                line = br.readLine();
            }
        } catch (IOException e) {
        }

    }
}
