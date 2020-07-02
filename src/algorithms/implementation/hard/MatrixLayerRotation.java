package algorithms.implementation.hard;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MatrixLayerRotation {

    static void printLayer(List<List<Integer>> matrix, int depth) {
        int rows = matrix.size() - 1 - (depth - 1);
        int cols = matrix.get(0).size() - 1 - (depth - 1);
        int trueDepth = depth - 1;
        for (int i = trueDepth; i <= rows; i++) {
            for (int j = trueDepth; j <= cols; j++) {
                if (i == trueDepth || j == trueDepth || i == rows || j == cols) {
                    if (i == trueDepth && j == trueDepth) {
                        System.out.print("leftTop");
                    } else if (i == rows && j == trueDepth) {
                        System.out.print("leftLast");

                    }
                    if (i == trueDepth && j == cols) {
                        System.out.print("rightTop");
                    } else if (i == rows && j == cols) {
                        System.out.print("rightLast");
                    }
                    System.out.print(matrix.get(i).get(j) + " ");
                }
                System.out.print("   ");
            }
            System.out.println();
        }
    }

    static void rotateLayer(List<List<Integer>> matrix, int layer) {
        int rows = matrix.size() - 1 - (layer - 1);
        int cols = matrix.get(0).size() - 1 - (layer - 1);
        int trueDepth = layer - 1;
        for (int i = trueDepth; i <= rows; i++) {
            for (int j = trueDepth; j <= cols; j++) {
                if (i == trueDepth || j == trueDepth || i == rows || j == cols) {

                    System.out.print(matrix.get(i).get(j) + " ");
                }
                System.out.print("   ");
            }
            System.out.println();
        }

        int row = 0;//trueDepth;
        int col = 0;//trueDepth;
        int dir = 1;
        int temp;
        do {

        }
        while (row == 0 && col == 0);

    }

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int rows = matrix.size();
        int columns = matrix.get(0).size();
        int depth = rows % 2 == 0 ? rows / 2 : columns / 2;

        printLayer(matrix, 1);
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "5 4 7\n" +
                "1 2 3 4\n" +
                "7 8 9 10\n" +
                "13 14 15 16\n" +
                "19 20 21 22\n" +
                "25 26 27 28";

        String input2 = "2 2 7\n" +
                "1 2 3 4\n" +
                "7 8 9 10\n";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes())));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }

}
