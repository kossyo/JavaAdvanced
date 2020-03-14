package LinearDataStructures;

import java.io.Console;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) throws IOException {

       Map<String , Integer> map  = new LinkedHashMap<>();
       map.put("kossyo", 20);
       map.put("sa6ko", 30);
       map.put("pe6o", 40);

        //Console.WriteLine(dict.First(x => x.Key.Length == 5));
        System.out.println(map.entrySet().stream().findFirst().filter(x -> x.getKey().length() >4));
    }
}
