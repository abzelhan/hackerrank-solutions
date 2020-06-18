package algorithms.implementation.easy;

import java.io.IOException;
import java.util.Scanner;

/**
 * URL : https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
 * <p>
 * Example:
 * <p>
 * Input:
 * 20 23 6
 * Output:
 * 2
 */
public class BeautifulDays {

    static int beautifulDays(int i, int j, int k) {
        int sum = 0;
        for (int l = i; l <= j; l++) {
            int temp = l;
            int reversed = 0;
            while (temp != 0) {
                int digit = temp % 10;
                reversed = reversed * 10 + digit;
                temp /= 10;
            }
            int diff = Math.abs(l - reversed);
            if (diff == 0 || (Double.valueOf(diff) / k) % 1 == 0) {
                sum++;
            }
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        System.out.println(result);
        scanner.close();
    }

}
