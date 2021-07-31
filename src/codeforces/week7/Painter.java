package codeforces.week7;

import java.util.Scanner;

public class Painter {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      long[] dp = new long[51];

      dp[1] = 3;

      for (int i = 2; i <= n; i++) {
         dp[i] = dp[i - 1] * 2;
      }

      System.out.println(dp[n]);

   }

}
