package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int dimensions = Integer.parseInt(input[0]);

        String patternType = input[1];

        int[][] matrix = new int[dimensions][dimensions];

        if (patternType.equals("A")) {
            fillTypeA(matrix);
        } else {
            fillTypeB(matrix);
        }

        printMatrix(matrix);
    }

    private static void fillTypeB(int[][] matrix) {
        int count = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 1) {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[j][i] = count;
                    count++;
                }
            } else {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = count;
                    count++;
                }
            }
        }
    }

    private static void fillTypeA(int[][] matrix) {
        int count = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = count;
                count++;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}