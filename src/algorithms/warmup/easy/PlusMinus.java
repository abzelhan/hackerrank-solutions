package algorithms.warmup.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
    Url: https://www.hackerrank.com/challenges/plus-minus/problem
 */
public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int positiveAmount = 0;
        int negativeAmount = 0;
        int zeroAmount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positiveAmount++;
            } else if (arr[i] < 0) {
                negativeAmount++;
            } else {
                zeroAmount++;
            }
        }

        System.out.println(new BigDecimal(positiveAmount).divide(BigDecimal.valueOf(arr.length), 6, BigDecimal.ROUND_HALF_UP));
        System.out.println(new BigDecimal(negativeAmount).divide(BigDecimal.valueOf(arr.length), 6, BigDecimal.ROUND_HALF_UP));
        System.out.println(new BigDecimal(zeroAmount).divide(BigDecimal.valueOf(arr.length), 6, BigDecimal.ROUND_HALF_UP));

    }

    private static final Scanner scanner = new Scanner(System.in);

    /*
    Sample input:
    6
    -4 3 -9 0 4 1
    Sample output:
    0.500000
    0.333333
    0.166667
     */
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
