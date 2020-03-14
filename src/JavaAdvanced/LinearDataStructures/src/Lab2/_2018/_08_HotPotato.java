
package Lab2._2018;

import java.util.*;

public class _08_HotPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] kidsArray = scanner.nextLine().split(" ");
        List<String> kids = new ArrayList<>(Arrays.asList(kidsArray));

        int interval = Integer.parseInt(scanner.nextLine());
        int offset = 0;
        int loserIndex = 0;

        while (kids.size() > 1) {

            loserIndex = (interval + offset - 1) % kids.size();

            System.out.println("Removed " + kids.get(loserIndex));
            kids = removeAt(kids, loserIndex);
            offset = loserIndex;

        }

        System.out.println("Last is " + kids.get(0));
    }

    static List removeAt(List list, int index) {

        try {
            list.remove(index);
            return list;

        } catch (UnsupportedOperationException uoe) {

            list.remove(index);
            return list;
        }

    }
}



