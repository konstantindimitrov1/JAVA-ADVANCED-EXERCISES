package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // fill the matrix
        int[] tokensForDimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = tokensForDimensions[0];
        int cols = tokensForDimensions[1];
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split(" ");
            // validate input
            boolean checkKeyword = checkCommand(tokens[0]);
            boolean checkInformation = checkCoordinatesCount(tokens.length);
            boolean checkValidCoordinates = validateCoordinates(matrix, tokens);

            if (checkInformation && checkKeyword && checkValidCoordinates) {
                // swap words
                int firstWordRow = Integer.parseInt(tokens[1]);
                int firstWordCol = Integer.parseInt(tokens[2]);
                String wordToSwap = matrix[firstWordRow][firstWordCol];
                int secondWordRow = Integer.parseInt(tokens[3]);
                int secondWordCol = Integer.parseInt(tokens[4]);
                matrix[firstWordRow][firstWordCol] = matrix[secondWordRow][secondWordCol];
                matrix[secondWordRow][secondWordCol] = wordToSwap;

                // print matrix
                printMatrix(matrix);
            } else {
                // print invalid
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }
    }

    private static boolean validateCoordinates(String[][] matrix, String[] tokens) {
        if (!checkCoordinatesCount(tokens.length)) {
            return false;
        }
        int firstWordRow = Integer.parseInt(tokens[1]);
        int firstWordCol = Integer.parseInt(tokens[2]);
        int secondWordRow = Integer.parseInt(tokens[3]);
        int secondWordCol = Integer.parseInt(tokens[4]);

        if (matrix.length <= firstWordRow || matrix.length <= secondWordRow || firstWordRow < 0 || secondWordRow < 0) {
            return false;
        }
        return matrix[0].length > firstWordCol && matrix[0].length > secondWordCol && firstWordCol >= 0 && secondWordCol >= 0;
    }

    private static boolean checkCoordinatesCount(int length) {
        return length == 5;
    }

    private static boolean checkCommand(String token) {
        return token.equals("swap");
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            StringBuilder output = new StringBuilder();
            for (String string : strings) {
                output.append(string).append(" ");
            }
            System.out.println(output.toString().trim());
        }
    }
}
