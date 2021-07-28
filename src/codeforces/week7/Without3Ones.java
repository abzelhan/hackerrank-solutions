package codeforces.week7;

import java.util.Scanner;

public class Without3Ones {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      long[][] dp = new long[51][3];

      dp[1][0] = 1;
      dp[1][1] = 1;
      dp[1][2] = 0;

      for (int i = 2; i <= n; i++) {
         dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
         dp[i][1] = dp[i - 1][0] ;
            dp[i][2] = dp[i - 1][1];
      }

      System.out.println(dp[n][0] + dp[n][1] + dp[n][2]);
   }

}
