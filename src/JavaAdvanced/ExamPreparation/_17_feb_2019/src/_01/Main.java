package _01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Long> lefts = Arrays.stream(reader.readLine().split("\\s+")).map(Long::parseLong).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Long> rights = Arrays.stream(reader.readLine().split("\\s+")).map(Long::parseLong).collect(Collectors.toCollection(ArrayDeque::new));

        List<Long> pairs = new LinkedList<>();

        while (!lefts.isEmpty() && !rights.isEmpty()){

            long left = lefts.peekLast();
            long right = rights.peekFirst();

            if (left > right){

                pairs.add(left + right);
                lefts.pollLast();
                rights.pollFirst();
            }
            else if(right > left){

                lefts.pollLast();
            }
            else{
                rights.pollFirst();
                Long incremented = lefts.pollLast();
                incremented += 1;
                lefts.addLast(incremented);
            }
        }

        System.out.println(Collections.max(pairs));
        System.out.println(pairs.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
