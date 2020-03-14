package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyComparator {


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5,4,3,20,66,456,987,51,5465,10236,456798);

        Comparator<Integer> myComparator = (a, b ) ->{

            boolean aIsEven = a % 2 == 0;
            boolean bIsEven = b % 2 == 0;

            if(aIsEven && !bIsEven){
                return -1;
            }
            else if(!aIsEven && bIsEven){
                return 1;
            }

            else{
                return a-b;
            }

        };
        list.sort(myComparator);
        list.forEach(x-> System.out.print(x + " "));

    }
}
