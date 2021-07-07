package leetcode.easy;

import java.util.HashMap;

public class ContainsDuplicateII {

   public static boolean containsNearbyDuplicate(int[] nums, int k) {
      HashMap<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
         if (map.containsKey(nums[i])) {
            Integer index = map.get(nums[i]);

            if (Math.abs(i - index) <= k) {
               return true;
            }

         }

         map.put(nums[i], i);

      }

      return false;
   }

   public static void main(String[] args) {
      System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
   }

}
