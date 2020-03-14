

package InputOutputFilesDirectories.Lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class _08_NestedFolders {
    public static void main(String[] args) {

        String path = "D:\\Kossyo\\Lessons\\LessonsJavaAdvanced\\New folder";
        File file = new File(path);
        Deque<File> deque = new ArrayDeque<>();
        deque.offer(file);

        int count = 0;
        while (!deque.isEmpty()) {
            File current = deque.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    deque.offer(nestedFile);
                }
            }
            count++;
            System.out.println(current.getName());
        }

        System.out.println(count + " folders");
    }
}
