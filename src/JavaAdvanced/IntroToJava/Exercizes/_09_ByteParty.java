package IntroToJava.Exercizes;

        import java.util.Arrays;
        import java.util.Scanner;

public class _09_ByteParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] numbersBi = new int[n][32];
        int[] numbersDec = new int[n];

        for(int i =0; i < n; i++){
            numbersDec[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < n; i++) {

            String currentNum = Integer.toBinaryString(numbersDec[i]);

            for(int j = 0; j <currentNum.length(); j++){

                numbersBi[i][numbersBi[i].length - j - 1] = (currentNum.charAt(currentNum.length() - j - 1))-48;
            }
        }

        while (true) {

            String command = scanner.nextLine();

            if (command.equals("party over")) {
                break;
            }

            String[] commands = command.split(" ");

            String action = commands[0];
            int position = Integer.parseInt(commands[1]);

            if(action.equals("-1")){

                for(int i = 0; i < n; i++){
                    numbersBi[i][31-position] = (numbersBi[i][31-position] == 0) ? 1 : 0;
                }
            }
            else if (action.equals("0")){
                for(int i = 0; i < n; i++){
                    numbersBi[i][31-position] = 0;
                }
            }

            else if (action.equals("1")){
                for(int i = 0; i < n; i++){
                    numbersBi[i][31-position] = 1;
                }
            }
        }

        for( int i = 0; i < n; i++){

            String resultBi = String.join("", Arrays.stream(numbersBi[i]).mapToObj(String::valueOf).toArray(String[]::new));
            System.out.println(Integer.parseInt(resultBi, 2));
        }
    }
}
