package leetcode.easy;

import java.util.HashSet;

public class ContainsDuplicateII {

   public static boolean containsNearbyDuplicate(int[] nums, int k) {

      HashSet<Integer> set = new HashSet<>();
      int i = 0, j = 0;

      while (j <= k && j < nums.length) {
         int element = nums[j++];

         if (!set.add(element)) {
            return true;
         }
      }

      while (j < nums.length) {
         set.remove(nums[i++]);
         int element = nums[j++];
         if (!set.add(element)) {
            return true;
         }
      }

      return false;
   }

   public static void main(String[] args) {
      System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
   }

}
