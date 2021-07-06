package leetcode.medium;

import java.util.Arrays;

public class WiggleSortII {

   public static void wiggleSort(int[] nums) {
      Arrays.sort(nums);

      int[] sortedArr = new int[nums.length];
      int j = nums.length - 1;
      for (int i = 1; i < nums.length; i += 2) {
         sortedArr[i] = nums[j--];
      }

      for (int i = 0; i < nums.length; i+= 2) {
         sortedArr[i] = nums[j--];
      }

      for (int i = 0; i < nums.length; i++) {
         nums[i] = sortedArr[i];
      }
   }

   public static void main(String[] args) {
      int[] nums = {1,5,1,1,6,4};
      wiggleSort(nums);
   }

}
