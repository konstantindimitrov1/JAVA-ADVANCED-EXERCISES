package SetsAndMaps;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();

        while (!input.equals("end")) {
            // get data
            String[] tokens = input.split(" ");
            String ip = tokens[0].substring(3);
            String username = tokens[2].substring(5);

            // fill data
            logs.putIfAbsent(username, new LinkedHashMap<>());
            LinkedHashMap<String, Integer> data = logs.get(username);
            data.putIfAbsent(ip, 0);
            data.put(ip, data.get(ip) + 1);
            logs.put(username, data);

            // new input
            input = scanner.nextLine();
        }

        // print
        logs.forEach((key, value) -> {
            System.out.println(key + ":");
            List<String> output = new ArrayList<>();
            value.forEach((key1, value1) -> {
                String toAdd = String.format("%s => %d", key1, value1);
                output.add(toAdd);
            });
            System.out.println(String.join(", ", output) + ".");
        });
    }
}
