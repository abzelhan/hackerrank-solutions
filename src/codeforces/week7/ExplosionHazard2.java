package codeforces.week7;

import java.util.Scanner;

public class ExplosionHazard2 {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int s = 0;
      int[][] dp = new int[20][3];

      dp[0][0] = dp[0][1] = dp[0][2] = 1;

      for (int i = 1; i < n; i++) {
         dp[i][0] = dp[i - 1][1] + dp[i - 1][2];
         dp[i][1] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
         dp[i][2] = dp[i][1];
      }

      for (int i = 0; i < 3; i++) {
         s += dp[n - 1][i];
      }

      System.out.println(s);
   }

}
