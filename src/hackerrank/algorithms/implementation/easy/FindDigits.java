package hackerrank.algorithms.implementation.easy;

import java.io.IOException;
import java.util.Scanner;

/**
 * URL: https://www.hackerrank.com/challenges/find-digits/problem
 * Input:
 * 2
 * 12
 * 1012
 * Output:
 * 2
 * 3
 */
public class FindDigits {

    static int findDigits(int n) {
        int r = n;
        int count = 0;
        while (r > 0) {
            if (r % 10 != 0 && n % (r % 10) == 0) count++;
            r = r / 10;
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            System.out.println(result);
        }

        scanner.close();
    }
}
