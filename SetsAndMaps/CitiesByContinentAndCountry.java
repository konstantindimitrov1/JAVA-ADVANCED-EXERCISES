package SetsAndMaps;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int linesCount = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, ArrayList<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < linesCount; i++) {
            // get data
            String[] tokens = scanner.nextLine().split(" ");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            // add data to map
            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>());
            map.get(continent).get(country).add(city);
        }

        // print
        map.forEach((key, value) -> {
            System.out.println(key + ":");
            value.forEach((key1, value1) -> System.out.println(key1 + " -> " + value1.toString().replaceAll("[\\[\\]]", "")));
        });
    }
}