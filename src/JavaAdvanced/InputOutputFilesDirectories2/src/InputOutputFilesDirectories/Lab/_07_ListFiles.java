package InputOutputFilesDirectories.Lab;

import java.io.File;

public class _07_ListFiles {
    public static void main(String[] args) {

        File rootDir = new File("D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04_Java_Advanced_Files_and_Streams_Lab_Resources\\Files_and_Streams");
        File[] files = rootDir.listFiles();

        for (File file : files) {
            System.out.printf("%s: %s\n", file.getName(), file.length());
        }
    }
}
