package codeforces.week7;

import java.util.Scanner;

public class Sequence0And1 {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      long[][] dp = new long[51][2];

      dp[1][0] = 1;
      dp[1][1] = 1;

      for (int i = 2; i <= n; i++) {
         dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
         dp[i][1] = dp[i-1][0];
      }

      System.out.println((long)Math.pow(2, n) - (dp[n][0] + dp[n][1]));
   }

}
