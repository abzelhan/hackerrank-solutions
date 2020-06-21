package algorithms.implementation.easy;

import java.io.IOException;
import java.util.Scanner;

/**
 * URL: https://www.hackerrank.com/challenges/permutation-equation/problem
 * Input:
 * 3
 * 2 3 1
 * Output:
 * 2
 * 3
 * 1
 */
public class SequenceEquation {

    static int[] permutationEquation(int[] p) {
        int[] result = new int[p.length];

        for (int i = 1; i <= p.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (i == p[j]) {
                    for (int k = 0; k < p.length; k++) {
                        if (j + 1 == p[k]) {
                            result[i - 1] = k + 1;
                            break;
                        }
                    }
                    break;
                }
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

            if (i != result.length - 1) {
                System.out.println("\n");
            }
        }

        scanner.close();
    }
}
