package leetcode.medium;

import java.util.Arrays;

public class LongestConsecutiveSequence {

   public static int longestConsecutive(int[] nums) {
      if (nums.length == 0) {
         return 0;
      }

      Arrays.sort(nums);

      int maxSequenceCount = 1;
      int tempSequenceCount = 1;
      for (int i = 1; i < nums.length; i++) {
         if (nums[i] == nums[i - 1]) {
            continue;
         }

         if (nums[i] - 1 == nums[i - 1]) {
            tempSequenceCount++;
         } else {
            maxSequenceCount = Math.max(maxSequenceCount, tempSequenceCount);
            tempSequenceCount = 1;
         }
      }

      return Math.max(maxSequenceCount, tempSequenceCount);
   }

   public static void main(String[] args) {
      System.out.println(longestConsecutive(new int[]{1,2,0,1}));
   }

}
