package StringProcessing.Lab;

import java.util.Scanner;

public class _02_ParseURL {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] protocolAndRest = input.split("://");

        if (protocolAndRest.length != 2) {

            System.out.println("Invalid URL");
            return;
        }

        String protocol = protocolAndRest[0];
        String serverAndResources = protocolAndRest[1];

        int firstIndexOfSlash = serverAndResources.indexOf("/");
        String server = serverAndResources.substring(0, firstIndexOfSlash);
        String recources = serverAndResources.substring(firstIndexOfSlash + 1);

        System.out.printf("Protocol = %s%n", protocol);
        System.out.printf("Server = %s%n", server);
        System.out.printf("Resources = %s%n", recources);
    }
}
