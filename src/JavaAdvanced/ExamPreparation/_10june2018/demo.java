package ExamPreparation._10june2018;

import java.util.*;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {

        Map<String, Long> map = new LinkedHashMap<>();
        map.put("kossyo", 20L);
        map.put("maria", 30L);
        map.put("sashko", 40L);

        System.out.println(
                map.values()
                        .stream()
                        .reduce(0L, Long::sum)
                        .longValue()
        );

        System.out.println();

    }
}
