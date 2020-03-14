package FunctionalProgramming.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _13_InfernoIII {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> items = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Filter> filters = new ArrayList<>();
        Set<Integer> indicesMustRemove = new HashSet<>();

        String commandInput;

        while (!"Forge".equals((commandInput = br.readLine()))) {

            String[] commandTokens = commandInput.split(";");
            String action = commandTokens[0];
            String filterType = commandTokens[1];
            int parameter = Integer.parseInt(commandTokens[2]);

            switch (action) {
                case "Exclude":

                    Filter filter = new Filter(filterType, parameter);
                    filters.add(filter);
                    break;
                case "Reverse":

                    filters.removeIf(x -> x.filterType.equals(filterType) && x.parameter == parameter);

                    break;
            }
        }

        for (int i = 0; i < items.size(); i++) {

            boolean thisItemMustBeRemoved = false;

            for (int j = 0; j < filters.size(); j++) {

                String filterType = filters.get(j).filterType;

                if (itemMustBeRemoved(filters, filterType, getWhatItShouldBeEqualTo(filterType, items, i))) {
                    thisItemMustBeRemoved = true;
                    break;
                }
            }

            if (thisItemMustBeRemoved) {

                indicesMustRemove.add(i);
            }
        }

        for (int i = 0; i < items.size(); i++) {

            if (!indicesMustRemove.contains(i)) {
                System.out.print(items.get(i) + " ");
            }
        }
    }

    private static int getWhatItShouldBeEqualTo(String filterType, List<Integer> items, int i) {

        int whatShouldItBeEqualTo = 0;
        int previous = (i - 1 >= 0) ? items.get(i - 1) : 0;
        int current = items.get(i);
        int next = (i + 1 < items.size()) ? items.get(i + 1) : 0;

        switch (filterType) {
            case "Sum Left":

                whatShouldItBeEqualTo = current + previous;
                break;

            case "Sum Right":

                whatShouldItBeEqualTo = current + next;
                break;

            case "Sum Left Right":

                whatShouldItBeEqualTo = current + previous + next;
                break;
        }
        return whatShouldItBeEqualTo;

    }

    private static boolean itemMustBeRemoved(List<Filter> listOfFilters, String filterType, int shouldBeEqualToWhat) {

        boolean itemMustBeRemovedBool = false;
        for (int i = 0; i < listOfFilters.size(); i++) {

            if (listOfFilters.get(i).filterType.equals(filterType)
                    && listOfFilters.get(i).parameter == shouldBeEqualToWhat) {

                itemMustBeRemovedBool = true;
                break;
            }
        }
        return itemMustBeRemovedBool;
    }
}

class Filter {

    public String filterType;
    public int parameter;

    Filter(String filterType, int parameter) {

        this.filterType = filterType;
        this.parameter = parameter;

    }
}
