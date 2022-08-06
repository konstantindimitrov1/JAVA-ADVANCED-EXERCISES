package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int sumFirstDiagonal = 0;
        int sumSecondDiagonal = 0;
        for (int i = 0; i < size; i++) {
            sumFirstDiagonal += matrix[i][i];
            sumSecondDiagonal += matrix[i][size - 1 - i];
        }

        int absSum = Math.abs(sumFirstDiagonal - sumSecondDiagonal);
        System.out.println(absSum);
    }
}