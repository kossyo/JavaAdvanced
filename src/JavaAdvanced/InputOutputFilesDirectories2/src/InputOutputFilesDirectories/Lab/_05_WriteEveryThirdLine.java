package InputOutputFilesDirectories.Lab;

import java.io.*;


public class _05_WriteEveryThirdLine {
    public static void main(String[] args) {


        String inputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Lab-Resources\\input.txt";
        String outputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Lab-Resources\\outputEvery3rdLine.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
        PrintWriter pw = new PrintWriter(new FileWriter(outputPath))
        ){
            int counter = 1;
            String line = br.readLine();
            while(line != null){
                if (counter % 3 == 0){
                    pw.println(line);
                    //System.out.println(line);

                }
                counter++;
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
