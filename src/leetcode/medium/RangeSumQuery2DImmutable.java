package leetcode.medium;

public class RangeSumQuery2DImmutable {

   private static class NumMatrix {

      int[][] diagonalPrefixSum;
      int[][] matrix;

      public NumMatrix(int[][] matrix) {
         this.matrix = matrix;
         this.diagonalPrefixSum = new int[matrix.length][matrix[0].length];

         for (int i = 0; i < matrix.length; i++) {
            diagonalPrefixSum[i][0] = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
               diagonalPrefixSum[i][j] = diagonalPrefixSum[i][j - 1] + matrix[i][j];
            }
         }
      }

      public int sumRegion(int row1, int col1, int row2, int col2) {

         int totalSum = 0;
         for (int i = row1; i <= row2; i++) {

            if(col1 == 0) {
               totalSum += diagonalPrefixSum[i][col2];
            } else {
               totalSum += diagonalPrefixSum[i][col2] - diagonalPrefixSum[i][col1 - 1];
            }

            for (int j = col1; j <= col2; j++) {
               System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
         }
         return totalSum;
      }
   }

   public static void main(String[] args) {
      int[][] nums = {
          {3, 0, 1, 4, 2},
          {5, 6, 3, 2, 1},
          {1, 2, 0, 1, 5},
          {4, 1, 0, 1, 7},
          {1, 0, 3, 0, 5}
      };

      int[][] diagonalPrefixSum = new int[nums.length][nums[0].length];

      for (int i = 0; i < nums.length; i++) {
         diagonalPrefixSum[i][0] = nums[i][0];
         for (int j = 1; j < nums[i].length; j++) {
            diagonalPrefixSum[i][j] = diagonalPrefixSum[i][j - 1] + nums[i][j];
         }
      }

      NumMatrix numMatrix = new NumMatrix(nums);
      System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
      System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
      System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
   }

}
