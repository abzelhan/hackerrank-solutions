package hackerrank.algorithms.implementation.hard;

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

    static void rotateLayer(List<List<Integer>> matrix, int layer) {
        int rows = matrix.size() - 1 - (layer - 1);
        int cols = matrix.get(0).size() - 1 - (layer - 1);
        int trueDepth = layer - 1;

        int leftTop = matrix.get(trueDepth).get(trueDepth);
        int leftLast = matrix.get(rows).get(trueDepth);
        int rightTop = matrix.get(trueDepth).get(cols);
        int rightLast = matrix.get(rows).get(cols);

        //shift left side
        for (int i = (rows - 1); i >= trueDepth + 1; i--) {
            matrix.get(i + 1).set(trueDepth, matrix.get(i).get(trueDepth));
        }

        //shift bottom side
        for (int i = (cols - 1); i >= trueDepth + 1; i--) {
            matrix.get(rows).set(i + 1, matrix.get(rows).get(i));
        }

        //shift right side
        for (int i = trueDepth + 1; i <= rows - 1; i++) {
            matrix.get(i - 1).set(cols, matrix.get(i).get(cols));
        }

        //shift top side
        for (int i = trueDepth + 1; i <= cols - 1; i++) {
            matrix.get(trueDepth).set(i - 1, matrix.get(trueDepth).get(i));
        }

        //set left top edge
        matrix.get(trueDepth + 1).set(trueDepth, leftTop);

        //set left last edge
        matrix.get(rows).set(trueDepth + 1, leftLast);

        //set right top edge
        matrix.get(trueDepth).set(cols - 1, rightTop);

        //set right last edge
        matrix.get(rows - 1).set(cols, rightLast);

    }

    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int rows = matrix.size();
        int columns = matrix.get(0).size();

//        r = r % ((matrix.size() * 2) + ((matrix.get(0).size() - 2) * 2));

        int depth = rows % 2 == 0 ? rows / 2 : columns / 2;

        for (int i = 1; i <= depth; i++) {
            printLayer(matrix, i);
        }

        for (int i = 0; i < r; i++) {
            for (int j = 1; j <= depth; j++) {
                rotateLayer(matrix, j);
            }
        }

        printMatrix(matrix);
    }

    static void printLayer(List<List<Integer>> matrix, int depth) {

        int rows = matrix.size() - 1 - (depth - 1);
        int cols = matrix.get(0).size() - 1 - (depth - 1);
        int trueDepth = depth - 1;
        for (int i = trueDepth; i <= rows; i++) {
            for (int j = trueDepth; j <= cols ; j++) {
                if(i == trueDepth || j == trueDepth || i == rows || j == cols)
                    System.out.print(matrix.get(i).get(j) + " ");
                System.out.print("   ");
            }
            System.out.println();
        }

    }

    static void printMatrix(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "5 4 1\n" +
                "1 2 3 4\n" +
                "7 8 9 10\n" +
                "13 14 15 16\n" +
                "19 20 21 22\n" +
                "25 26 27 28";

        String input2 = "2 4 8\n" +
                "1 2 3 4\n" +
                "7 8 9 10\n";

        String input3 = "2 2 5\n" +
                "1 2\n" +
                "7 8 \n";

        String input4 = "4 4 2\n" +
                "1 2 3 4\n" +
                "5 6 7 8\n" +
                "9 10 11 12\n" +
                "13 14 15 16";

        String input5 = "10 8 2\n" +
                "9718805 60013003 5103628 85388216 21884498 38021292 73470430 31785927\n" +
                "69999937 71783860 10329789 96382322 71055337 30247265 96087879 93754371\n" +
                "79943507 75398396 38446081 34699742 1408833 51189 17741775 53195748\n" +
                "79354991 26629304 86523163 67042516 54688734 54630910 6967117 90198864\n" +
                "84146680 27762534 6331115 5932542 29446517 15654690 92837327 91644840\n" +
                "58623600 69622764 2218936 58592832 49558405 17112485 38615864 32720798\n" +
                "49469904 5270000 32589026 56425665 23544383 90502426 63729346 35319547\n" +
                "20888810 97945481 85669747 88915819 96642353 42430633 47265349 89653362\n" +
                "55349226 10844931 25289229 90786953 22590518 54702481 71197978 50410021\n" +
                "9392211 31297360 27353496 56239301 7071172 61983443 86544343 43779176";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input4.getBytes())));

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
