package algorithms.implementation.easy;

import java.io.IOException;
import java.util.Scanner;

/**
 * URL: https://www.hackerrank.com/challenges/strange-advertising/problem
 * Example:
 * <p>
 * Input:
 * 5
 * Output:
 * 24
 */
public class ViralAdvertising {

    static int viralAdvertising(int n) {
        int sum = 0;
        int people = 5;
        for (int i = 1; i <= n; i++) {
            int likes = people / 2;
            people = likes * 3;

            sum += likes;
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        System.out.println(result);
        scanner.close();
    }
}
