package InputOutputFilesDirectories.Lab;

import java.io.*;

public class _03_CopyBytes {
    public static void main(String[] args) throws IOException {

        String inputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04_Java_Advanced_Files_and_Streams_Lab_Resources\\Files_and_Streams\\input.txt";
        String outputPath = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04_Java_Advanced_Files_and_Streams_Lab_Resources\\Files_and_Streams\\outputOneHouseHold.txt";

        try (InputStream fis = new FileInputStream(inputPath);
             OutputStream fos = new FileOutputStream(outputPath)) {

            int oneByte = 0;

            while ((oneByte = fis.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    fos.write(oneByte);
                } else {
                    String number = String.valueOf(oneByte);
                    for (int i = 0; i < number.length(); i++) {

                        fos.write(number.charAt(i));
                    }
                }
            }
            //System.out.println();
        }
    }
}
