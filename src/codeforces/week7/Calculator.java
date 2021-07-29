package codeforces.week7;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();

      long[] dp = new long[n + 1];
      int[] path = new int[n + 1];

      dp[1] = 0;
      path[1] = 0;

      for (int i = 2; i <= n; i++) {
         dp[i] = dp[i - 1] + 1;
         path[i] = i - 1;

         if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
            dp[i] = dp[i / 2] + 1;
            path[i] = i / 2;
         }

         if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
            dp[i] = dp[i / 3] + 1;
            path[i] = i / 3;
         }
      }

      List<Integer> pathList = new LinkedList<>();

      for (int i = n; i > 1; i = path[i]) {
         if (i == path[i] + 1) {
            pathList.add(1);
         } else if (i == path[i] * 2) {
            pathList.add(2);

         } else if (i == path[i] * 3) {
            pathList.add(3);

         }
      }

      Collections.reverse(pathList);

      System.out.println(dp[n]);

      for (int i : pathList) {
         System.out.print(i + " ");
      }

   }

}
