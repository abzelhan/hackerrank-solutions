package algorithms.implementation.medium;

import java.io.IOException;
import java.util.Scanner;

/**
 * URL: https://www.hackerrank.com/challenges/magic-square-forming/problem
 * Input:
 * 5 3 4
 * 1 5 8
 * 6 4 2
 * Output:
 * 7
 */
public class FormingMagicSquare {

    static int formingMagicSquare(int[][] s) {
        int totals[] = new int[8];

        int[][][] data = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
        };

        for (int i = 0; i < data.length; i++) {
            int total = 0;
            for (int j = 0; j < data[i].length; j++) {
                for (int k = 0; k < data[i][j].length; k++) {
                    int sV = s[j][k];
                    int dV = data[i][j][k];
                    if (sV != dV) {
                        total += Math.max(sV, dV) - Math.min(sV, dV);
                    }
                }
            }
            totals[i] = total;
        }

        int minCost = -1;

        for (int i = 0; i < totals.length; i++) {
            if (minCost == -1) {
                minCost = totals[i];
                continue;
            }
            if (minCost > totals[i]) {
                minCost = totals[i];
            }
        }

        return minCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        System.out.println(result);

        scanner.close();
    }
}


