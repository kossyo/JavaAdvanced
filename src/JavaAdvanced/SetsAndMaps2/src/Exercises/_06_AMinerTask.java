    package Exercises;

    import java.util.LinkedHashMap;
    import java.util.Map;
    import java.util.Scanner;

    public class _06_AMinerTask {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            Map<String, Integer> lhm = new LinkedHashMap<>();


            while (true)
            {
                String metal = scanner.nextLine();

                if ("stop".equals(metal))
                {
                    break;
                }

                int quantity = Integer.parseInt(scanner.nextLine());

                if (!lhm.containsKey(metal))
                {
                    lhm.put(metal,quantity);
                }

                else
                {
                    lhm.put(metal, lhm.get(metal) + quantity);
                }
            }

            for (Map.Entry kvp : lhm.entrySet())
            {
                System.out.printf("%s -> %d\n", kvp.getKey(), kvp.getValue());
            }

        }
    }
