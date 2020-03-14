package InputOutputFilesDirectories.Lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class _06_SortLines {
    public static void main(String[] args) throws IOException {

        String inputPathStr = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04_Java_Advanced_Files_and_Streams_Lab_Resources\\Files_and_Streams\\ABCDinput.txt";
        String outputPathStr = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\04_Java_Advanced_Files_and_Streams_Lab_Resources\\Files_and_Streams\\ABCSoutput.txt";

        Path inputPath = Paths.get(inputPathStr);
        Path outputPath = Paths.get(outputPathStr);

        List<String> lines = Files.readAllLines(inputPath);
        lines.sort(Comparator.naturalOrder());

        Files.write(outputPath, lines);
    }
}
