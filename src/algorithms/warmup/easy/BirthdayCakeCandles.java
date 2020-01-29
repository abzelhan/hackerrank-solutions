package algorithms.warmup.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
    URL: https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 */
public class BirthdayCakeCandles {

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] ar) {
        int maxHeight = 0;

        for (int i = 0; i < ar.length; i++) {
            if (maxHeight == 0 && ar[i] != 0) {
                maxHeight = ar[i];
            } else if (ar[i] > maxHeight) {
                maxHeight = ar[i];
            }
        }

        int maxHeightCandles = 0;

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == maxHeight) {
                maxHeightCandles++;
            }
        }

        return maxHeightCandles;
    }

    private static final Scanner scanner = new Scanner(System.in);

    /*
    Input:
    4
    3 2 1 3
    Output:
    2
     */
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result.txt"));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
