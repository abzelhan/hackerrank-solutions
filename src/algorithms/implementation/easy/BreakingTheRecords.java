package algorithms.implementation.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
    URL: https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 */
public class BreakingTheRecords {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        int []counts = {0, 0};
        int highest = -1;
        int lowest = -1;
        for (int score : scores) {
            if (highest == lowest && highest == -1) {
                highest = score;
                lowest = highest;
                continue;
            }
            if (lowest > score) {
                lowest = score;
                counts[1]++;
                continue;
            }
            if (highest < score) {
                highest = score;
                counts[0]++;
                continue;
            }
        }

        return counts;
    }

    private static final Scanner scanner = new Scanner(System.in);

    /*
        Input:
         10
         3 4 21 36 10 28 35 5 24 42
        Output:
        4 0
     */
    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

        }

        scanner.close();
    }
}

