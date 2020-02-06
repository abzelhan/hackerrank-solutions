package algorithms.implementation.easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
    URL: https://www.hackerrank.com/challenges/kangaroo/problem
 */
public class Kangaroo {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        int iterations = 0;
        while (iterations != 10000) {
            x1 = x1 + v1;
            x2 = x2 + v2;
            if (x1 == x2) return "YES";

            iterations++;
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    /*
        Input:
        0 3 4 2
        Output:
        YES
     */
    public static void main(String[] args) throws IOException {

        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        System.out.println(result);

        scanner.close();
    }
}

