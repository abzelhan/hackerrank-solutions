package leetcode.medium.dp;

public class MaxProductSubArray {

   public int maxProduct(int[] nums) {
      int[][] dp = new int[nums.length + 1][2];

      dp[0][0] = nums[0];
      dp[0][1] = nums[0];
      int maxProduct = dp[0][0];

      for (int i = 1; i < nums.length; i++) {

         if (nums[i] < 0) {
            int temp = dp[i - 1][0];
            dp[i - 1][0] = dp[i - 1][1];
            dp[i - 1][1] = temp;
         }

         int maxDp = dp[i - 1][0] * nums[i];
         int minDp = dp[i - 1][1] * nums[i];

         dp[i][0] = Math.max(nums[i], maxDp);
         dp[i][1] = Math.min(nums[i], minDp);

         if (maxProduct < dp[i][0]) {
            maxProduct = dp[i][0];
         }
      }

      return maxProduct;
   }

   public static void main(String[] args) {
      System.out.println(new MaxProductSubArray().maxProduct(new int[]{-2, 0, -1}));
   }

}
