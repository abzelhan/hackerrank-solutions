package codeforces.week7;

import java.util.Scanner;

public class SimpleSequence {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int[] dp = new int[1001];

      dp[0] = 1;
      dp[1] = 1;

      for (int i = 2; i <= n; i++) {
         if (i % 2 == 0) {
            dp[i] = dp[i / 2] + dp[(i / 2) - 1];
         } else {
            dp[i] = dp[i / 2] - dp[(i / 2) - 1];
         }
      }

      System.out.println(dp[n]);
   }

}
