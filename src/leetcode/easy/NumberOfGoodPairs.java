package leetcode.easy;

import java.util.*;
import java.util.Map.Entry;

/**
 * https://leetcode.com/problems/number-of-good-pairs/
 *
 * Time Complexity O(n ^ 2)
 */
public class NumberOfGoodPairs {

   public static int numIdenticalPairs(int[] nums) {
      Map<Integer, Integer> dictionary = new HashMap<>();
      int totalPairs = 0;
      for(int i = 0; i < nums.length; i++) {
         if (!dictionary.containsKey(nums[i])) {
            dictionary.put(nums[i], 1);
         } else {
            Integer occurences = dictionary.get(nums[i]);
            totalPairs += occurences;
            dictionary.put(nums[i], occurences + 1);
         }
      }

      return totalPairs;
   }

   public static void main(String[] args) {
      System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
   }

}
