package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // rotation degrees
        String inputRotation = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(inputRotation);
        int rotation = 0;
        if (matcher.find()) {
            rotation = Integer.parseInt(matcher.group());
        }

        // get col length
        int colMaxLength = 1;
        // get data
        List<String> data = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            data.add(input);
            if (input.length() > colMaxLength) {
                colMaxLength = input.length();
            }
            input = scanner.nextLine();
        }

        // fill the matrix
        char[][] matrix = new char[data.size()][colMaxLength];
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < colMaxLength; j++) {
                if (j < data.get(i).length()) {
                    matrix[i][j] = data.get(i).charAt(j);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        // rotate
        int rotationsCount = rotation / 90;
        for (int i = 0; i < rotationsCount; i++) {
            char[][] rotatedMatrix = new char[matrix[0].length][matrix.length];
            for (int o = 0; o < rotatedMatrix.length; o++) {
                for (int j = 0; j < rotatedMatrix[0].length; j++) {
                    rotatedMatrix[o][j] = matrix[matrix.length - 1 - j][o];
                }
            }
            matrix = rotatedMatrix.clone();
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            StringBuilder output = new StringBuilder();
            for (char aChar : chars) {
                output.append(aChar);
            }
            System.out.println(output);
        }
    }
}