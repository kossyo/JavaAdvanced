package InputOutputFilesDirectories.Exercises;

import java.io.*;

public class _05_LineNumbers {
    public static void main(String[] args) {

        String inputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Exercises-Resources\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Exercises-Resources\\StringProcessing.FunctionalProgramming.Exercises Resources\\inputLineNumbers.txt";
        String outputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Exercises-Resources\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Exercises-Resources\\StringProcessing.FunctionalProgramming.Exercises Resources\\output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             PrintWriter pw = new PrintWriter(new FileWriter(outputPath)))
        {
            String line = "";
            int counter = 1;

            while ((line = br.readLine()) != null){

                pw.println(counter + ". " + line);
//                System.out.println(counter + ". " + line);

                counter++;
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
