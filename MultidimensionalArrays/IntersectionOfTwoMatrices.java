package MultidimensionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrix1 = readMatrix(scanner, rows, cols);
        char[][] matrix2 = readMatrix(scanner, rows, cols);

        printOverlayMatrices(matrix1, matrix2);
    }

    private static void printOverlayMatrices(char[][] matrix1, char[][] matrix2) {
        for (int i = 0; i < matrix1.length; i++) {
            String output = "";
            for (int j = 0; j < matrix1[i].length; j++) {
                char firstMatrix = matrix1[i][j];
                char secondMatrix = matrix2[i][j];
                output = firstMatrix == secondMatrix ? output + firstMatrix + " " : output + "* ";
            }
            System.out.println(output);
        }
    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                matrix[i][j] = input[j].charAt(0);
            }
        }
        return matrix;
    }
}
