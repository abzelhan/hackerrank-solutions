package easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
    Problem URL: https://www.hackerrank.com/challenges/diagonal-difference/problem
 */
class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            leftDiagonalSum += arr.get(i).get(i);
            rightDiagonalSum += arr.get(i).get(arr.size()-i-1);
        }
        return Math.abs(leftDiagonalSum-rightDiagonalSum);
    }

}

/*
  Sample input:
    3
    11 2 4
    4 5 6
    10 8 -12
    Sample output:
    15
 */
public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        System.out.println(result);

        bufferedReader.close();
    }
}
