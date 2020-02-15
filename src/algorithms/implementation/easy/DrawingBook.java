package algorithms.implementation.easy;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/*
    URL: https://www.hackerrank.com/challenges/drawing-book/problem
 */
public class DrawingBook {

    static int pageCount(int n, int p) {
        if(p == 1 || n == 1) return 0;
        if((n % 2 == 0) && (p == n -1) ) return 1;
        int forward = p / 2;
        int backward = (n - p) / 2;
        return forward < backward ? forward : backward;
    }

    private static final Scanner scanner = new Scanner(System.in);

    /*
        Input:
        6
        5
        Output:
        1
     */
    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();

        int p = scanner.nextInt();

        int result = pageCount(n, p);

        System.out.println(result);

        scanner.close();
    }
}
