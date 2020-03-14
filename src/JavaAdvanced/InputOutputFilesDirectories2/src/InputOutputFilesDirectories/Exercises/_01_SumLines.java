package InputOutputFilesDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _01_SumLines {
    public static void main(String[] args) throws IOException {

        String inputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Lab-Resources\\exerc1.txt";

        BufferedReader br = new BufferedReader(new FileReader(inputPath));
        //OR: BufferedReader br = Files.newBufferedReader(Paths.get(inputPath));

        String line = br.readLine();

        while (line != null) {
            long sum = 0;

            for (char c : line.toCharArray()) {
                sum += c;
            }
            System.out.println(sum);
            line = br.readLine();
        }


        //OR:


        //try (BufferedReader br = Files.newBufferedReader(Paths.get(inputPath))) {
        //
        //            String line = br.readLine();
        //            while (line != null){
        //                long sum = 0;
        //
        //                for (char c : line.toCharArray()) {
        //                    sum += c;
        //                }
        //                System.out.println(sum);
        //                line = br.readLine();
        //            }
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }

    }
}
