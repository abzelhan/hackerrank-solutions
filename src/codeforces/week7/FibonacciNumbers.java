package codeforces.week7;

import java.util.Scanner;

public class FibonacciNumbers {

   public static long fibonacci(int n, long[] dp) {
      if (n == 1 || n == 0) {
         return n;
      }
      if (dp[n] == 0) {
         dp[n] = (fibonacci(n - 1, dp) % 10) + (fibonacci(n - 2, dp) % 10);
      }

      return dp[n];
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      long[] dp = new long[1001];

      long fibonacci = fibonacci(n, dp);
      System.out.println(fibonacci % 10);
   }

}
