package InputOutputFilesDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class _01_ReadFile {
    public static void main(String[] args) {

        String path = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04_Java_Advanced_Files_and_Streams_Lab_Resources\\Files_and_Streams\\input.txt";

        try (FileInputStream fis = new FileInputStream(path)){

            int oneByte = fis.read();
            while (oneByte >= 0){
                System.out.printf("%s ",Integer.toBinaryString(oneByte));
                oneByte = fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
