package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix1 = fillMatrix(scanner);
        int[][] matrix2 = fillMatrix(scanner);

        String output = compareMatrices(matrix1, matrix2) ? "equal" : "not equal";
        System.out.println(output);
    }

    private static boolean compareMatrices(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            int[] firstArr = matrix1[i];
            int[] secondArr = matrix2[i];
            if (firstArr.length != secondArr.length) {
                return false;
            }
            for (int j = 0; j < firstArr.length; j++) {
                if (firstArr[j] != secondArr[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] fillMatrix(Scanner scanner) {
        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[tokens[0]][tokens[1]];
        for (int i = 0; i < tokens[0]; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}