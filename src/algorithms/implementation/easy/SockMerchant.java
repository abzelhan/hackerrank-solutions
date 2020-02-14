package algorithms.implementation.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
    URL: https://www.hackerrank.com/challenges/sock-merchant/problem
 */
public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {
        int pairSum = 0;
        boolean[] skipPos = new boolean[ar.length];

        for (int i = 0; i < ar.length; i++) {
            if (!skipPos[i]) {
                int sock = ar[i];
                for (int j = i + 1; j < ar.length ; j++) {
                    if (ar[j] == sock) {
                        pairSum++;
                        skipPos[j] = true;
                        break;
                    }
                }
            }
        }
        return pairSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    /*
        Input:
        9
        10 20 20 10 10 30 50 10 20
        Output:
        3
     */
    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.println(result);
        scanner.close();
    }
    
}
