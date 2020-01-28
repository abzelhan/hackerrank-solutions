package algorithms.warmup.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
  Link to problem: https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */
public class CompareTheTriplets {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> alicePoints, List<Integer> bobPoints) {

        int categoryAmount = 3;
        int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0; i < categoryAmount; i++) {
            if (alicePoints.get(i) > bobPoints.get(i)) {
                aliceScore++;
            } else if (alicePoints.get(i) < bobPoints.get(i)) {
                bobScore++;
            }
        }

        return Arrays.asList(aliceScore, bobScore);
    }

    /*
        Sample input:
        5 6 7
        3 6 10
        Sample output:
        1 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        bufferedReader.close();

        List<Integer> result = compareTriplets(a, b);

        System.out.println(result.stream().map(n -> n.toString()).collect(Collectors.joining(" ")));
    }
}
