package hackerrank.algorithms.implementation.easy;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.*;

/**
 * URL: https://www.hackerrank.com/challenges/sherlock-and-squares/problem
 * Input:
 * 2
 * 3 9
 * 17 24
 * Output:
 * 2
 * 0
 */
public class SherlockAndSquares {

    static int squares(int a, int b) {

        double ceil = ceil(sqrt(a));
        double floor = floor(sqrt(b));
        return (int) (floor - ceil + 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println((sqrt(9) - (int) sqrt(9)) == 0);
        System.out.println(sqrt(19) - (int) sqrt(19) == 0);

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            System.out.println(result);
        }

        scanner.close();
    }
}
