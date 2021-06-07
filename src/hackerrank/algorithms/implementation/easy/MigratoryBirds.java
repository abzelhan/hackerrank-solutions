package hackerrank.algorithms.implementation.easy;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
    URL:https://www.hackerrank.com/challenges/migratory-birds/problem
 */
public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {

        int[] birdIds = {1, 2, 3, 4, 5};
        int[] idCounts = {0, 0, 0, 0, 0};

        for (int i = 0; i < arr.size(); i++) {
            int counts = idCounts[arr.get(i) - 1];
            idCounts[arr.get(i) - 1] = counts + 1;
        }

        int maxId = 0;
        int maxOccurrenceCount = -1;

        for (int i = 0; i < idCounts.length; i++) {
            if (maxOccurrenceCount < idCounts[i]) {
                maxId = i;
                maxOccurrenceCount = idCounts[i];
            }
        }

        return maxId + 1;
    }

    /*
        Input:
        11
        1 2 3 4 5 4 3 2 1 3 4
        Output:
        3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = migratoryBirds(arr);
        System.out.println(result);
        bufferedReader.close();
    }
}
