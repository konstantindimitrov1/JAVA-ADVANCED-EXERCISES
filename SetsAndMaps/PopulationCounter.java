package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> populationMap = new LinkedHashMap<>();

        Map<String, Long> totalPopulation = new LinkedHashMap<>();

        while (!input.equals("report")) {
            // get data
            String[] tokens = input.split("[|]");
            String city = tokens[0];
            String country = tokens[1];
            int population = Integer.parseInt(tokens[2]);

            // fill data
            populationMap.putIfAbsent(country, new LinkedHashMap<>());
            populationMap.get(country).putIfAbsent(city, population);
            totalPopulation.putIfAbsent(country, 0L);
            totalPopulation.put(country, totalPopulation.get(country) + population);

            // get new input
            input = scanner.nextLine();
        }

        // print
        populationMap.entrySet().stream()
                .sorted((c1, c2) -> totalPopulation.get(c2.getKey()).compareTo(totalPopulation.get(c1.getKey())))
                .forEach(country -> {
                    System.out.format("%s (total population: %d)\n", country.getKey(), totalPopulation.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue())).forEach(city -> System.out.format("=>%s: %d\n", city.getKey(), city.getValue()));
                });

    }
}