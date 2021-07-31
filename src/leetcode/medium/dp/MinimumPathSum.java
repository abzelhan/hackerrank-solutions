package leetcode.medium.dp;

public class MinimumPathSum {

   public int minPathSum(int[][] grid) {
      int[][] dp = new int[grid.length][grid[0].length];

      for (int i = 0; i < grid.length; i++) {
         for (int j = 0; j < grid[0].length; j++) {
            dp[i][j] = grid[i][j];

         }
      }

      for (int i = 1; i < grid[0].length; i++) {
         dp[0][i] += dp[0][i - 1];
      }

      for (int i = 1; i < grid.length; i++) {
         dp[i][0] += dp[i - 1][0];
      }

      for (int i = 1; i < grid.length; i++) {
         for (int j = 1; j < grid[0].length; j++) {
            dp[i][j] = Math.min(dp[i - 1][j] + dp[i][j], dp[i][j - 1] + dp[i][j]);
         }
      }

      return dp[grid.length - 1][grid[0].length -1];
   }

   public static void main(String[] args) {
      System.out.println(new MinimumPathSum().minPathSum(new int[][]{
          {1, 2, 3},
          {4, 5, 6}
      }));
   }

   /**
    *
    * 2
    * 00
    * 01
    * 10
    * 11
    *
    * 3
    *
    * 000
    * 010
    * 100
    * 110 +
    * 001
    * 011 +
    * 101
    * 111 +
    *
    * 0000
    * 0100
    * 1000
    * 1100 +
    * 0010
    * 0110 +
    * 1010
    * 1110 +
    * 0001
    * 0101
    * 1001
    * 1101 +
    * 0011 +
    * 0111 +
    * 1011 +
    * 1111 +
    *
    *
    *
    */

}
