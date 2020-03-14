package IntroToJava.Exercizes;

import java.util.Scanner;

public class _10_XBits {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        int num4 = Integer.parseInt(scanner.nextLine());
        int num5 = Integer.parseInt(scanner.nextLine());
        int num6 = Integer.parseInt(scanner.nextLine());
        int num7 = Integer.parseInt(scanner.nextLine());
        int num8 = Integer.parseInt(scanner.nextLine());

        String[] binary = new String[8];

        binary[0] = String.format("%32s", Integer.toBinaryString(num1)).replace(" ", "0");
        binary[1] = String.format("%32s", Integer.toBinaryString(num2)).replace(" ", "0");
        binary[2] = String.format("%32s", Integer.toBinaryString(num3)).replace(" ", "0");
        binary[3] = String.format("%32s", Integer.toBinaryString(num4)).replace(" ", "0");
        binary[4] = String.format("%32s", Integer.toBinaryString(num5)).replace(" ", "0");
        binary[5] = String.format("%32s", Integer.toBinaryString(num6)).replace(" ", "0");
        binary[6] = String.format("%32s", Integer.toBinaryString(num7)).replace(" ", "0");
        binary[7] = String.format("%32s", Integer.toBinaryString(num8)).replace(" ", "0");

        int count = 0;

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 30; j++){

                String current1 = binary[i].charAt(j) + "" + binary[i].charAt(j+1) + binary[i].charAt(j+2);
                String current2 = binary[i+1].charAt(j) + "" + binary[i+1].charAt(j+1) + binary[i+1].charAt(j+2);
                String current3 = binary[i+2].charAt(j) + "" + binary[i+2].charAt(j+1) + binary[i+2].charAt(j+2);


                if(current1.equals("101") && current2.equals("010") && current3.equals("101")){

                    count++;
                }

            }
        }
        System.out.println(count);
    }
}
