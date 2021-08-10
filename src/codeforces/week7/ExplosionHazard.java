package codeforces.week7;

import java.util.Scanner;

public class ExplosionHazard {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      long[][] dp = new long[21][3];

      dp[1][0] = 1;
      dp[1][1] = 1;
      dp[1][2] = 1;

/*

0

0 - 1
1 - 1

1

0 1
1 1
0 0
1 0

3

0 1 0
1 1 0
0 0 0
1 0 0
0 1 1
1 1 1
0 0 1
1 0 1

8

0 1 0 0
1 1 0 0 -
0 0 0 0
1 0 0 0
0 1 1 0 -
1 1 1 0 -
0 0 1 0
1 0 1 0
0 1 0 1
1 1 0 1
0 0 0 1
1 0 0 1
0 1 1 1 -
1 1 1 1 -
0 0 1 1 -
1 0 1 1 -


0 1 0 0 0
1 1 0 0 0    1
0 0 0 0 0
1 0 0 0 0
0 1 1 0 0    2
1 1 1 0 0    3
0 0 1 0 0
1 0 1 0 0
0 1 0 1 0
1 1 0 1 0    4
0 0 0 1 0
1 0 0 1 0
0 1 1 1 0    5
1 1 1 1 0    6
0 0 1 1 0    7
1 0 1 1 0    8
0 1 0 0 1
1 1 0 0 1    9
0 0 0 0 1
1 0 0 0 1
0 1 1 0 1    10
1 1 1 0 1    11
0 0 1 0 1
1 0 1 0 1
0 1 0 1 1    12
1 1 0 1 1    13
0 0 0 1 1    14
1 0 0 1 1    15
0 1 1 1 1    16
1 1 1 1 1    17
0 0 1 1 1    18
1 0 1 1 1    19

 */

      for (int i = 2; i <= n; i++) {
         dp[i][0] = dp[i - 1][0] + dp[i - 1][0];
         dp[i][1] = dp[i - 1][1] + dp[i - 1][0];
         dp[i][2] = dp[i - 1][1] ;
      }

      int sum = 0;

      for (int i = 1; i <= n; i++) {
         sum += dp[i][2];
      }

      System.out.println(sum);

   }

}
