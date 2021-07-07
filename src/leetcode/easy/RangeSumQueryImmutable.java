package leetcode.easy;

import java.util.Arrays;

/**
 * Solved using prefix sum approach
 */
public class RangeSumQueryImmutable {

   static class NumArray {

      int[] nums;
      int[] prefixSum;

      public NumArray(int[] nums) {
         this.nums = nums;
         this.prefixSum = new int[nums.length];
         prefixSum[0] = nums[0];

         for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
         }
      }

      public int sumRange(int left, int right) {
         if (left == 0) {
            return prefixSum[right];
         }
         return prefixSum[right] - prefixSum[left - 1];
      }
   }

   public static void main(String[] args) {
      int[] nums = {-2, 0, 3, -5, 2, -1};
      int[] prefixSum = new int[nums.length];

      prefixSum[0] = nums[0];

      for (int i = 1; i < nums.length; i++) {
         prefixSum[i] = prefixSum[i - 1] + nums[i];
      }

      System.out.println(Arrays.toString(prefixSum));

      NumArray numArray = new NumArray(nums);
      System.out.println(numArray.sumRange(0, 2));
      System.out.println(numArray.sumRange(5, 5));
   }

}
