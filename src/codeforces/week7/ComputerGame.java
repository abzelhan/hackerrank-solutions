package codeforces.week7;

import java.util.Scanner;

public class ComputerGame {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int[] energy = new int[n + 1];
      int[] dp = new int[n + 1];

      for (int i = 0; i < n; i++) {
         energy[i] = scanner.nextInt();
      }

      dp[0] = 0;
      dp[1] = Math.abs(energy[1] - energy[0]);

      for (int i = 2; i < n; i++) {
         dp[i] = Math.min(Math.abs(energy[i] - energy[i - 1]) + dp[i - 1],
             Math.abs(energy[i] - energy[i - 2]) * 3 + dp[i - 2]);
      }

      System.out.println(dp[n - 1]);
   }

}
