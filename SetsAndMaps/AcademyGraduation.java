package SetsAndMaps;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());

        Map<String, Double> studentGrades = new TreeMap<>();

        for (int i = 0; i < studentsCount; i++) {
            String studentName = scanner.nextLine();
            double averageGrade = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).average().getAsDouble();
            studentGrades.put(studentName, averageGrade);
        }

        studentGrades.forEach((key, value) -> System.out.printf("%s is graduated with %f\n", key, value));
    }
}