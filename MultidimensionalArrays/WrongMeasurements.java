package MultidimensionalArrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] tokens = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int invalidNumber = matrix[tokens[0]][tokens[1]];

        ArrayDeque<Integer> queueForSum = new ArrayDeque<>();
        ArrayDeque<Integer> queueRow = new ArrayDeque<>();
        ArrayDeque<Integer> queueCol = new ArrayDeque<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == invalidNumber) {
                    int number = changeTheNumber(matrix, row, col, invalidNumber);
                    queueForSum.offer(number);
                    queueRow.offer(row);
                    queueCol.offer(col);
                }
            }
        }

        while (!queueForSum.isEmpty()) {
            matrix[queueRow.pop()][queueCol.pop()] = queueForSum.pop();
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    static int changeTheNumber(int[][] matrix, int row, int col, int invalidNumber) {
        int correctNumber = 0;
        //down
        if (row > 0) {
            if (matrix[row - 1][col] != invalidNumber) {
                correctNumber += matrix[row - 1][col];
            }
        }
        //up
        if (row < matrix.length - 1) {
            if (matrix[row + 1][col] != invalidNumber) {
                correctNumber += matrix[row + 1][col];
            }
        }
        //right
        if (col > 0) {
            if (matrix[row][col - 1] != invalidNumber) {
                correctNumber += matrix[row][col - 1];
            }
        }
        //left
        if (col < matrix[row].length - 1) {
            if (matrix[row][col + 1] != invalidNumber) {
                correctNumber += matrix[row][col + 1];
            }
        }
        return correctNumber;
    }
}