package codeforces.week7;

import java.util.Scanner;

public class Ladder {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int[] dp = new int[31];

      dp[0] = 1;
      dp[1] = 1;
      dp[2] = 2;

      for (int i = 3; i <= n; i++) {
         dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
      }

      System.out.println(dp[n]);
   }

}
