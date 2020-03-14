package Lab;

import java.util.*;

public class _02_SoftuniParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> regular = new TreeSet<>();
        Set<String> vip = new TreeSet<>();

        String input = scanner.nextLine();

        while (!"PARTY".equals(input)){

            if (Character.isDigit(input.charAt(0))){
                vip.add(input);
            }

            else{
                regular.add(input);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while(!"END".equals(input)){
            if (Character.isDigit(input.charAt(0))){
                vip.remove(input);
            }

            else{
                regular.remove(input);
            }
            input = scanner.nextLine();

        }

        System.out.println(regular.size() + vip.size());

        for (String s : vip) {
            System.out.println(s);
        }
        for (String s : regular) {
            System.out.println(s);
        }
    }
}
