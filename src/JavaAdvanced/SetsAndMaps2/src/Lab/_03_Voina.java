package Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _03_Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> p1 = new LinkedHashSet<>();
        Set<Integer> p2 = new LinkedHashSet<>();

        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");

        for (int i = 0; i < input2.length; i++) {
            String s1 = input1[i];
            String s2 = input2[i];

            p1.add(Integer.parseInt(s1));
            p2.add(Integer.parseInt(s2));

        }

        for (int i = 0; i < 50; i++) {

            if (p2.isEmpty()){
                System.out.println("First player win!");
                return;
            }

            if (p1.isEmpty()){
                System.out.println("Second player win!");
                return;
            }

            int current1 = p1.iterator().next();
            int current2 = p2.iterator().next();


            p1.remove(current1);
            p2.remove(current2);


            if (current1 > current2){

                p1.add(current1);
                p1.add(current2);


            }
            else if (current1 < current2){


                p2.add(current1);
                p2.add(current2);
            }
        }

        if (p1.size() > p2.size())
            System.out.println("First player win!");

        else if (p1.size() < p2.size())
            System.out.println("Second player win!");

        else
            System.out.println("Draw!");




    }
}
