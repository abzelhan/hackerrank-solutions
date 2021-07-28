package codeforces.week7;

import java.util.Arrays;
import java.util.Scanner;

public class Nails {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int[] dp = new int[n + 1];
      int[] coordinates = new int[n + 1];

      for (int i = 1; i <= n; i++) {
         coordinates[i] = scanner.nextInt();
      }

      Arrays.sort(coordinates);

      dp[1] = Integer.MAX_VALUE;
      dp[2] = coordinates[2] - coordinates[1];
      dp[3] = dp[2] + coordinates[3] - coordinates[2];

      for (int i = 3; i <= n; i++) {
         dp[i] = Math.min(dp[i - 1], dp[i - 2]) + (coordinates[i] - coordinates[i - 1]);
      }

      System.out.println(dp[n]);

   }

}
