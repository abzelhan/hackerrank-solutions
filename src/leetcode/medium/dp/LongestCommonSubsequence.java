package leetcode.medium.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {

   public void printMatrix(int[][] matrix) {
      for (int i = 0; i < matrix.length; i++) {
         System.out.println(Arrays.toString(matrix[i]));
      }
   }

   public int longestCommonSubsequence(String text1, String text2) {
      int m = text1.length();
      int n = text2.length();

      int[][] dp = new int[m + 1][n + 1];

      for (int i = 1; i <= m; i++) {
         for (int j = 1; j <= n; j++) {
            char ch1 = text1.charAt(i - 1);
            char ch2 = text2.charAt(j - 1);

            if (ch1 == ch2) {
               dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
               dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }

         }
      }

      return dp[m][n];
   }

   public static void main(String[] args) {

   }

}
