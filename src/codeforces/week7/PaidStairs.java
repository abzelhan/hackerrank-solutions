package codeforces.week7;

import java.util.Scanner;

public class PaidStairs {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int[] stairs = new int[n];
      int[] dp = new int[n + 1];
      for (int i = 0; i < n; i++) {
         stairs[i] = scanner.nextInt();
      }

      dp[0] = 0;
      dp[1] = stairs[0];

      for (int i = 2; i <= n; i++) {
         dp[i] = Math.min(stairs[i - 1] + dp[i - 1], stairs[i - 1] + dp[i - 2]);
      }

      System.out.println(dp[n]);
   }

}
