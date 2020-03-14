package IntroToJava.Exercizes;

import java.util.Scanner;


public class _12_VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        char[] inventoryType = new char[input.length];
        String[] inventorySeating = new String[input.length];
        long[] prices = new long[input.length];

        for (int i = 0; i < prices.length; i++) {

            char currentVehicleType = input[i].charAt(0);
            int currentSeating = Integer.parseInt(input[i].substring(1));

            prices[i] = currentVehicleType * currentSeating;
            inventoryType[i] = (char)((int)currentVehicleType - 32);
            inventorySeating[i] = currentSeating + "";
        }

        String query = scanner.nextLine();
        int soldCounter = 0;
        while(!"End of customers!".equals(query)){

            char queryType = query.charAt(0);
            String querySeating = query.split(" ")[2];
            boolean sold = false;
            for(int i = 0; i < prices.length; i++){

                if (inventoryType[i] == queryType && inventorySeating[i].equals(querySeating)

                && !"sold".equals(input[i]))
                {
                    System.out.printf("Yes, sold for %d$\n", prices[i]);
                    input[i] = "sold";
                    sold = true;
                    soldCounter++;
                    break;
                }


            }

            if (!sold){
                System.out.println("No");
            }

            query = scanner.nextLine();
        }

        String remaining = "";

        for (int i = 0; i < input.length; i++) {

            if (!"sold".equals(input[i])){
                remaining += input[i] + ", ";
            }
        }
        if (remaining.length() != 0) {
            remaining = remaining.substring(0, remaining.length() - 2);
        }
        System.out.println("Vehicles left: " + remaining);
        System.out.println("Vehicles sold: " + soldCounter);
    }
}
