package hackerrank.algorithms.implementation.easy;

import java.io.IOException;
import java.util.Scanner;

/**
 * URL: https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem
 * Example:
 * Input:
 * 8 2
 * 0 0 1 0 0 1 1 0
 * Output:
 * 92
 */
public class JumpingOnTheClouds {

    static int jumpingOnClouds(int[] c, int k) {
        int pos = 0;
        int energy = 100;
        do {
            if (c[pos] == 1) energy -= 2;
            energy--;
            pos = (pos + k) <= c.length - 1 ? pos + k : (pos + k) % c.length;
        }
        while (pos != 0);
        return energy;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);
        System.out.println(result);

        scanner.close();
    }

}

