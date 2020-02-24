package algorithms.implementation.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
    URL: https://www.hackerrank.com/challenges/the-hurdle-race/problem
 */
public class TheHurdleRace {

    // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {
        int max = -1;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }

        return max <= k ? 0 : max - k;
    }

    private static final Scanner scanner = new Scanner(System.in);

    /*
    Input:
    5 4
    1 6 3 5 2
    Output:
    2
     */
    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] height = new int[n];

        String[] heightItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int heightItem = Integer.parseInt(heightItems[i]);
            height[i] = heightItem;
        }

        int result = hurdleRace(k, height);
        System.out.println(result);

        scanner.close();
    }
}
