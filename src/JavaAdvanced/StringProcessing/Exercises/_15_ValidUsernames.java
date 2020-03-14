package StringProcessing.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _15_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] array = input.split("[\\\\ /()]+");
        List<String> allUsers = new LinkedList<>(Arrays.asList(array));

        String validUserRegex = "^[A-Za-z]\\w{2,24}$";
        Pattern pattern = Pattern.compile(validUserRegex);

        List<String> validUsersList = new LinkedList<>();

        validUsersList = allUsers.stream().filter(x -> {
            Matcher matcher = pattern.matcher(x);
            if (matcher.find()){
                return true;
            }
            else{
                return false;
            }
        }).collect(Collectors.toList());

        String[] twoConseqUsersMaxSummedLengths = new String[2];
        int maxSummedLengths = 0;
        for (int i = 0; i < validUsersList.size() - 1; i++) {

            int currentCoupleLengthsSum = validUsersList.get(i).length() + validUsersList.get(i+1).length();
            if (currentCoupleLengthsSum > maxSummedLengths){

                maxSummedLengths = currentCoupleLengthsSum;
                twoConseqUsersMaxSummedLengths[0] = validUsersList.get(i);
                twoConseqUsersMaxSummedLengths[1] = validUsersList.get(i+1);
            }
        }

        Arrays.stream(twoConseqUsersMaxSummedLengths).forEach(x -> System.out.println(x));
    }
}
