package SetsAndMaps;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get total grades
        int grades = Integer.parseInt(scanner.nextLine());

        // initialize ds
        Map<String, List<Double>> studentGrades = new TreeMap<>();

        for (int i = 0; i < grades; i++) {
            // get data for grades and student
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            // fill data
            List<Double> gradesList;
            if (!studentGrades.containsKey(name)) {
                gradesList = new ArrayList<>();
            } else {
                gradesList = studentGrades.get(name);
            }
            gradesList.add(grade);
            studentGrades.put(name, gradesList);
        }

        // print
        studentGrades.forEach((key, value) -> {
            double sum = 0;
            for (Double aDouble : value) {
                sum += aDouble;
            }
            double avgSum = sum / value.size();

            System.out.print(key + " -> ");
            value.forEach(e -> System.out.printf("%.2f ", e));
            System.out.printf("(avg: %.2f)%n", avgSum);
        });

    }
}