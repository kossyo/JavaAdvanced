import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        List<String> strings = new LinkedList<>();

        strings.add("pesho");
        strings.add("gosho");
        strings.add("tosho");

        strings = strings
                .stream()
                .sorted((name1, name2) -> name1.compareTo(name2))
                .collect(Collectors.toList());
    }
}
