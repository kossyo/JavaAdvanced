package InputOutputFilesDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class _04_ExtractIntegers {
    public static void main(String[] args) throws IOException {

//        String inputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04_Java_Advanced_Files_and_Streams_Lab_Resources\\input.txt";
//        String outputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04_Java_Advanced_Files_and_Streams_Lab_Resources\\outputExtractedInts.txt";
//
//        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
//             PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath))) {
//            {
//                while (scanner.hasNext()) {
//                    if (scanner.hasNextInt()) {
//
//                        writer.println(scanner.nextInt());
//                    }
//                    scanner.next();
//                }
//
//
//            }
//        }

        String inputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Lab-Resources\\input.txt";
        String outputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04. Java-Advanced-Files-and-Streams-StringProcessing.FunctionalProgramming.Lab-Resources\\outputExtractedInts.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter pw = new PrintWriter(new FileOutputStream(outputPath))) {
            {
                while (scanner.hasNext()) {
                    if (scanner.hasNextInt()) {

                        pw.println(scanner.nextInt());
                        //pw.println("kur");
                    }
                    scanner.next();
                }


            }
        }
    }
}

