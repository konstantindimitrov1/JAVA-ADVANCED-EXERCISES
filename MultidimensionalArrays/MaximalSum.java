package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = tokens[0];
        int cols = tokens[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int bestSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;

        int[][] matrixToPrint = new int[3][3];

        int row = 0;
        int col = 0;
        while (row < rows - 2) {
            while (col < cols - 2) {
                int sum = 0;
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        sum += matrix[i][j];
                    }
                }
                if (sum > bestSum) {
                    bestSum = sum;
                    startRow = row;
                    startCol = col;
                }
                col++;
            }
            row++;
            col = 0;
        }

        fillTheMatrix(matrix, matrixToPrint, startRow, startCol);


        System.out.printf("Sum = %d\n", bestSum);
        for (int[] ints : matrixToPrint) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static void fillTheMatrix(int[][] matrix, int[][] matrixToPrint, int startRow, int startCol) {
        int countRow = 0;
        int countCol = 0;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                matrixToPrint[countRow][countCol] = matrix[i][j];
                countCol++;
            }
            countRow++;
            countCol = 0;
        }
    }
}