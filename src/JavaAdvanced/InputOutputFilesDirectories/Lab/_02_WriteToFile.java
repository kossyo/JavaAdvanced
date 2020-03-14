package InputOutputFilesDirectories.Lab;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _02_WriteToFile {
    public static void main(String[] args) {

        String inputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04_Java_Advanced_Files_and_Streams_Lab_Resources\\input.txt";
        String outputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04_Java_Advanced_Files_and_Streams_Lab_Resources\\output2.txt";

        try (InputStream fis = new FileInputStream(inputPath);
             OutputStream fos = new FileOutputStream(outputPath)) {

            int oneByte = 0;
            List<Character> skipSymbols = new ArrayList<>(Arrays.asList(',', '.', '!', '?'));
            oneByte = fis.read();
            while ((oneByte) >= 0) {
                if (!skipSymbols.contains((char) oneByte)) {
                    fos.write(oneByte);
                    //System.out.println(oneByte);
                }
                oneByte = fis.read();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
