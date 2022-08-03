package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get input
        double[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        // make data structure
        Map<Double, Integer> mapOfOccurrence = new LinkedHashMap<>();

        // fill ds
        for (double v : input) {
            if (mapOfOccurrence.containsKey(v)) {
                int occurrence = mapOfOccurrence.get(v);
                mapOfOccurrence.put(v, occurrence + 1);
            }
            mapOfOccurrence.putIfAbsent(v, 1);
        }

        mapOfOccurrence.forEach((key, value) -> System.out.printf("%.1f -> %d\n", key, value));

    }
}