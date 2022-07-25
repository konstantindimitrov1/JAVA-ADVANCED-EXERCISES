package SetsAndMaps;

import java.util.*;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // create ds
        Map<String, Set<String>> usersAndIP = new TreeMap<>();
        Map<String, Integer> userOnlineDuration = new TreeMap<>();

        int connectionsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < connectionsCount; i++) {
            // get data
            String[] tokens = scanner.nextLine().split(" ");
            String username = tokens[1];
            String IP = tokens[0];
            int duration = Integer.parseInt(tokens[2]);

            // fill data
            usersAndIP.putIfAbsent(username, new TreeSet<>());
            userOnlineDuration.putIfAbsent(username, 0);
            Set<String> fillSet = usersAndIP.get(username);
            fillSet.add(IP);
            usersAndIP.put(username, fillSet);
            userOnlineDuration.put(username, userOnlineDuration.get(username) + duration);
        }

        // print
        usersAndIP.forEach((key, value) -> {
            System.out.printf("%s: %d ", key, userOnlineDuration.get(key));
            System.out.println(value.toString());
        });
    }
}