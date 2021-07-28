package codeforces.week7;

import java.util.Scanner;

public class HardSequence {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int[] dp = new int[100001];

      dp[0] = 1;
      dp[1] = 1;

      for (int i = 1; i <= n; i++) {
         dp[i * 2] = dp[i] + 1;
         dp[i * 2 + 2] = dp[i * 2 + 1] - dp[i];
         dp[i * 2 + 1] = dp[i + 1] + 1 + dp[i];
      }

      System.out.println(dp[n]);
   }

}
