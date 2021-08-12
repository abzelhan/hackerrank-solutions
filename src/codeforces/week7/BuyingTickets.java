package codeforces.week7;

import java.util.Scanner;

public class BuyingTickets {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();

      int[] a = new int[n + 1];
      int[] b = new int[n + 1];
      int[] c = new int[n + 1];

      int[] dp = new int[n + 1];

      for (int i = 1; i <= n; i++) {
         a[i] = scanner.nextInt();
         b[i] = scanner.nextInt();
         c[i] = scanner.nextInt();
      }

      dp[0] = 0;
      dp[1] = a[1];
      dp[2] = Math.min(a[1] + a[2], b[1]);

      for (int i = 3; i <= n; i++) {
         dp[i] = Math.min(dp[i - 1] + a[i], Math.min(dp[i - 2] + b[i - 1], dp[i - 3] + c[i - 2]));
      }

      System.out.println(dp[n]);

   }

}
