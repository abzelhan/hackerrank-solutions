package algorithms.warmup.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
    URL: https://www.hackerrank.com/challenges/mini-max-sum/problem
 */
public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long minSum=0;
        long maxSum=0;

        int skipIndex = 0;

        while (skipIndex != arr.length) {
            long sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (skipIndex != j) {
                    sum += arr[j];
                }
            }
            if (sum != 0 && minSum == 0) {
                minSum = sum;
            } else if (sum < minSum) {
                minSum = sum;
            }

            if (sum != 0 && maxSum == 0) {
                maxSum = sum;
            } else if (sum > maxSum) {
                maxSum = sum;
            }
            skipIndex++;
        }

        System.out.println(minSum + " " + maxSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    /*
        Input:
        256741038 623958417 467905213 714532089 938071625
        Output:
        2063136757 2744467344
     */
    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
